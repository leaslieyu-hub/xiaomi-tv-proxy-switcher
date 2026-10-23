package local.tv.stockhome;
import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.content.ComponentName;
import android.provider.Settings;
import android.widget.Toast;
public class MainActivity extends Activity {
  @Override public void onCreate(Bundle state) {
    super.onCreate(state);
    try {
      String services = Settings.Secure.getString(getContentResolver(), Settings.Secure.ENABLED_ACCESSIBILITY_SERVICES);
      if (services != null) Settings.Secure.putString(getContentResolver(), Settings.Secure.ENABLED_ACCESSIBILITY_SERVICES, services.replace(":com.gathin.tvhome/.HomeKeyService", "").replace("com.gathin.tvhome/.HomeKeyService", ""));
      startActivity(new Intent(Intent.ACTION_MAIN).setComponent(new ComponentName("com.mitv.tvhome", "com.mitv.tvhome.MainActivity")));
    }
    catch (RuntimeException e) { Toast.makeText(this,"无法打开小米桌面",Toast.LENGTH_LONG).show(); }
    finish();
  }
}
