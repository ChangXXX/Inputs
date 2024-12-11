package git.changxxx.core.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import git.changxxx.core.data.usecase.GetImageListUseCaseImpl
import git.changxxx.core.domain.usecase.GetImageListUseCase

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class WriteModule {

    @Binds
    abstract fun bindGetImageListUseCase(uc: GetImageListUseCaseImpl): GetImageListUseCase
}