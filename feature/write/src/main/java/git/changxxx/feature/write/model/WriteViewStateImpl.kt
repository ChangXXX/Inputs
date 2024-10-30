package git.changxxx.feature.write.model

import kotlinx.coroutines.flow.MutableStateFlow

data class WriteViewStateImpl(
    override val writeItemList: MutableStateFlow<List<WriteItem>> = MutableStateFlow(emptyList()),
) : WriteViewState