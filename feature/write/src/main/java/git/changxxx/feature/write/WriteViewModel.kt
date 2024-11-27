package git.changxxx.feature.write

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import git.changxxx.feature.write.model.WriteItem
import git.changxxx.feature.write.model.WriteViewEvent
import git.changxxx.feature.write.model.WriteViewState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.runningFold
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class WriteViewModel @Inject constructor() : ViewModel() {

    private val _writeViewEvent: Channel<WriteViewEvent> = Channel()
    val writeViewState = _writeViewEvent.receiveAsFlow().runningFold(
        WriteViewState(),
        ::handleViewEvent
    ).stateIn(
        viewModelScope,
        SharingStarted.Eagerly,
        WriteViewState()
    )

    fun setEvent(event: WriteViewEvent) {
        _writeViewEvent.trySend(event)
    }

    private fun handleViewEvent(currentState: WriteViewState, event: WriteViewEvent): WriteViewState {
        return when (event) {
            WriteViewEvent.ShowWriteBottomSheet -> {
                currentState.copy(showWriteBottomSheet = true)
            }

            WriteViewEvent.HideWriteBottomSheet -> {
                currentState.copy(showWriteBottomSheet = false)
            }

            is WriteViewEvent.OnTextEditorResult -> {
                currentState.copy(
                    writeItemList = currentState.writeItemList.toMutableList().apply {
                        add(
                            0,
                            WriteItem.TextItem(
                                textStyle = event.result.textStyle,
                                text = event.result.text,
                                textSize = event.result.textSize
                            )
                        )
                    }
                )
            }
        }
    }
}