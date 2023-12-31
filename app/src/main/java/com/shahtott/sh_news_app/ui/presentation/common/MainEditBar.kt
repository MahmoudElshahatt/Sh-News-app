package com.shahtott.sh_news_app.ui.presentation.common

import android.content.res.Configuration
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shahtott.sh_news_app.R
import com.shahtott.sh_news_app.ui.presentation.Dimens
import com.shahtott.sh_news_app.ui.presentation.Dimens.SearchIconSize
import com.shahtott.sh_news_app.ui.theme.ShNewsappTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainEditBar(
    modifier: Modifier = Modifier,
    text: String,
    readOnly: Boolean,
    textStyle: TextStyle = MaterialTheme.typography.bodySmall.copy(fontSize = 13.sp),
    startIconId: Int = R.drawable.ic_search,
    startIconTint: Int = R.color.body,
    onClick: (() -> Unit)? = null,
    onValueChanged: (String) -> Unit,
    onSearch: (() -> Unit)? = null,
) {

    val interactionSource = remember {
        MutableInteractionSource()
    }

    val isClicked = interactionSource.collectIsPressedAsState().value


    LaunchedEffect(key1 = isClicked) {
        if (isClicked) {
            onClick?.invoke()
        }
    }

    Box(modifier = modifier) {

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .searchBarBorder(),
            value = text,
            textStyle = textStyle,
            readOnly = readOnly,
            onValueChange = onValueChanged,
            leadingIcon = {
                Icon(
                    painter = painterResource(id = startIconId),
                    contentDescription = null,
                    modifier = Modifier.size(SearchIconSize),
                    tint = colorResource(id = startIconTint)
                )
            },
            placeholder = {
                Text(
                    text = stringResource(R.string.search),
                    style = textStyle,
                    color = colorResource(id = R.color.placeholder)
                )
            },
            shape = MaterialTheme.shapes.medium,
            colors = TextFieldDefaults.textFieldColors(
                containerColor = colorResource(id = R.color.input_background),
                textColor = if (isSystemInDarkTheme()) Color.White else Color.Black,
                cursorColor = if (isSystemInDarkTheme()) Color.White else Color.Black,
                disabledIndicatorColor = Color.Transparent,
                errorIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            ),
            singleLine = true,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(
                onSearch = {
                    onSearch?.invoke()
                }
            ),
            interactionSource = interactionSource
        )
    }


}

fun Modifier.searchBarBorder() = composed {
    if (!isSystemInDarkTheme()) {
        border(
            width = 1.dp,
            color = Color.Black,
            shape = MaterialTheme.shapes.medium
        )
    } else {
        border(
            width = 1.dp,
            color = Color.White,
            shape = MaterialTheme.shapes.medium
        )
    }
}


@Composable
@Preview(showSystemUi = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showSystemUi = true)
private fun PreviewSearchBar() {
    ShNewsappTheme {
        Surface {
            MainEditBar(
                modifier = Modifier
                    .padding(horizontal = Dimens.padding16),
                text = "",
                readOnly = true,
                onValueChanged = {},
                onClick = {},
                onSearch = {}
            )

        }
    }

}