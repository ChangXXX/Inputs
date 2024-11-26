package git.changxxx.feature.write.model

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

data class WriteViewStateImpl(
    override val writeItemList: MutableStateFlow<List<WriteItem>>,
    override val showWriteBottomSheet: MutableStateFlow<Boolean> = MutableStateFlow(false)
) : WriteViewState