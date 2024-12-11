package git.changxxx.core.domain.usecase

import git.changxxx.core.domain.model.Image

interface GetImageListUseCase {
    suspend operator fun invoke(): List<Image>
}