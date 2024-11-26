package git.changxxx.feature.write

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import git.changxxx.feature.write.model.WriteItem
import git.changxxx.feature.write.model.WriteViewEvent
import git.changxxx.feature.write.model.WriteViewState
import git.changxxx.feature.write.model.WriteViewStateImpl
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.concurrent.atomic.AtomicInteger
import javax.inject.Inject

@HiltViewModel
internal class WriteViewModel @Inject constructor() : ViewModel() {

    private val idInc = AtomicInteger(1)

    private val _writeViewState = WriteViewStateImpl()
    val writeViewState: WriteViewState = _writeViewState

    private val _writeViewEvent: MutableSharedFlow<WriteViewEvent> = MutableSharedFlow<WriteViewEvent>()

    init {

        viewModelScope.launch {
            _writeViewEvent.collect(::handleWriteViewEvent)
        }
    }

    fun setEvent(event: WriteViewEvent) {
        viewModelScope.launch {
            _writeViewEvent.emit(event)
        }
    }

    private fun handleWriteViewEvent(event: WriteViewEvent) {
        when (event) {
            WriteViewEvent.ShowWriteBottomSheet -> {
                _writeViewState.showWriteBottomSheet.update { true }
            }
            WriteViewEvent.HideWriteBottomSheet -> {
                _writeViewState.showWriteBottomSheet.update { false }
            }
            is WriteViewEvent.OnTextEditorResult -> {
                _writeViewState.writeItemList.update {
                    it.toMutableList().apply {
                        add(
                            0,
                            WriteItem.TextItem(
                                textStyle = event.result.textStyle,
                                text = event.result.text,
                                textSize = event.result.textSize
                            )
                        )
                    }
                }
            }
        }
    }
}