package git.changxxx.feature.write.model

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

internal interface WriteViewState {
    val writeItemList: StateFlow<List<WriteItem>>
}