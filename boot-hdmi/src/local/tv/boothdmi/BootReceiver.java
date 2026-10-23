package local.tv.boothdmi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootReceiver extends BroadcastReceiver {
  @Override public void onReceive(Context context, Intent intent) {
    if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction()) || Intent.ACTION_LOCKED_BOOT_COMPLETED.equals(intent.getAction())) {
      Intent i = new Intent(Intent.ACTION_MAIN);
      i.setComponent(new android.content.ComponentName("com.xiaomi.mitv.tvplayer", "com.xiaomi.mitv.tvplayer.ExternalSourceActivity"));
      i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
      try { context.startActivity(i); } catch (RuntimeException ignored) { }
    }
  }
}
