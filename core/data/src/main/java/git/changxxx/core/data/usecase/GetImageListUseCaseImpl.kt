package git.changxxx.core.data.usecase

import android.content.ContentUris
import android.content.Context
import android.provider.MediaStore
import android.provider.MediaStore.Images
import dagger.hilt.android.qualifiers.ApplicationContext
import git.changxxx.core.androidutil.OsVersionUtils
import git.changxxx.core.domain.model.Image
import git.changxxx.core.domain.usecase.GetImageListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetImageListUseCaseImpl @Inject constructor(
    @ApplicationContext private val context: Context,
) : GetImageListUseCase {
    override suspend fun invoke(): List<Image> = withContext(Dispatchers.IO) {
        val contentResolver = context.contentResolver
        val projection = arrayOf(
            Images.Media._ID,
            Images.Media.DISPLAY_NAME,
            Images.Media.SIZE,
            Images.Media.MIME_TYPE,
        )
        val collectionUri = if (OsVersionUtils.isGreaterOrEqualThanQ()) {
            Images.Media.getContentUri(MediaStore.VOLUME_EXTERNAL)
        } else {
            Images.Media.EXTERNAL_CONTENT_URI
        }

        val images = mutableListOf<Image>()

        contentResolver.query(
            collectionUri,
            projection,
            null,
            null,
            "${Images.Media.DATE_ADDED} DESC"
        )?.use { cursor ->
            val idColumn = cursor.getColumnIndexOrThrow(Images.Media._ID)
            val displayNameColumn = cursor.getColumnIndexOrThrow(Images.Media.DISPLAY_NAME)
            val sizeColumn = cursor.getColumnIndexOrThrow(Images.Media.SIZE)
            val mimeTypeColumn = cursor.getColumnIndexOrThrow(Images.Media.MIME_TYPE)

            while (cursor.moveToNext()) {
                val uri = ContentUris.withAppendedId(collectionUri, cursor.getLong(idColumn))
                val name = cursor.getString(displayNameColumn)
                val size = cursor.getLong(sizeColumn)
                val mimeType = cursor.getString(mimeTypeColumn)

                val image = Image(
                    uri = uri.toString(),
                    name = name,
                    size = size,
                    mimeType = mimeType
                )
                images.add(image)
            }
        }

        return@withContext images
    }
}