package git.changxxx.core.androidutil

import android.os.Build
import androidx.annotation.ChecksSdkIntAtLeast

object OsVersionUtils {
    private val currentSdkVersion = Build.VERSION.SDK_INT

    @ChecksSdkIntAtLeast(parameter = 0)
    private fun isGreaterThanOrEquals(@SdkVersion sdkVersion: Int) = currentSdkVersion >= sdkVersion

    @ChecksSdkIntAtLeast(api = Build.VERSION_CODES.S)
    fun isGreaterOrEqualThanS(): Boolean {
        return isGreaterThanOrEquals(Build.VERSION_CODES.S)
    }
}

@Retention(AnnotationRetention.SOURCE)
internal annotation class SdkVersion