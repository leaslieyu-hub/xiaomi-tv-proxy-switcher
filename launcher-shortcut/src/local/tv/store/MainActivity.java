package local.tv.launcher;
import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.content.ComponentName;
import android.widget.Toast;
public class MainActivity extends Activity {
  @Override public void onCreate(Bundle state) {
    super.onCreate(state);
    try { startActivity(new Intent(Intent.ACTION_MAIN).setComponent(new ComponentName("com.gathin.tvhome", "com.gathin.tvhome.MainActivity"))); }
    catch (RuntimeException e) { Toast.makeText(this,"无法打开简洁桌面",Toast.LENGTH_LONG).show(); }
    finish();
  }
}
