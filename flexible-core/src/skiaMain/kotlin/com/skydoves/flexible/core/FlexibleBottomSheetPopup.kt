/*
 * Designed and developed by 2023 skydoves (Jaewoong Eum)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
@file:OptIn(ExperimentalComposeUiApi::class)

package com.skydoves.flexible.core

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntRect
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupPositionProvider
import androidx.compose.ui.window.PopupProperties

/**
 * Popup specific for flexible bottom sheet.
 */
@Composable
@InternalFlexibleApi
public actual fun FlexibleBottomSheetPopup(
  onDismissRequest: () -> Unit,
  windowInsets: WindowInsets,
  sheetState: FlexibleSheetState,
  content: @Composable BoxScope.() -> Unit,
) {
  Popup(
    popupPositionProvider = object : PopupPositionProvider {
      override fun calculatePosition(
        anchorBounds: IntRect,
        windowSize: IntSize,
        layoutDirection: LayoutDirection,
        popupContentSize: IntSize,
      ) = IntOffset.Zero
    },
    onDismissRequest = onDismissRequest,
    properties = PopupProperties(
      focusable = true,
      usePlatformInsets = false,
    ),
  ) {
    Box(modifier = Modifier.windowInsetsPadding(windowInsets)) {
      content()
    }
  }
}