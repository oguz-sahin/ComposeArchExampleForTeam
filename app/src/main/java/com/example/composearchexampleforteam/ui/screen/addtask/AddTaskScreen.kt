package com.example.composearchexampleforteam.ui.screen.addtask

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearchexampleforteam.R
import com.example.composearchexampleforteam.ui.theme.Orange


@Composable
fun AddTaskScreen(
    navigateDetailScreen: () -> Unit,
    viewModel: AddTaskViewModel
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(top = 16.dp, start = 16.dp, end = 16.dp)

    ) {
        BigTitleItem(
            title = stringResource(id = R.string.new_task),
            modifier = Modifier.padding(top = 8.dp)
        )
        TitleItem(
            title = stringResource(id = R.string.categories),
            modifier = Modifier.padding(top = 16.dp)
        )

        Categories(viewModel)

        TitleItem(
            title = stringResource(id = R.string.name),
            modifier = Modifier.padding(top = 16.dp)
        )

        NameTextField(
            value = viewModel.taskUiState.name,
            onNameChanged = viewModel::onTaskNameChanged
        )

        TitleItem(
            title = stringResource(id = R.string.description),
            modifier = Modifier.padding(top = 32.dp)
        )

        DescriptionTextField(
            value = viewModel.taskUiState.description,
            onDescriptionChanged = viewModel::onTaskDescriptionChanged
        )

        AddButton(navigateDetailScreen)

    }

}

@Composable
fun AddButton(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(top = 16.dp)
            .fillMaxWidth(),
        shape = CircleShape
    ) {
        Text(
            modifier = Modifier.padding(vertical = 4.dp),
            text = stringResource(id = R.string.Add),
            color = Color.White,
            fontSize = 16.sp
        )
    }
}

@Composable
fun DescriptionTextField(
    value: String,
    onDescriptionChanged: (String) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
    ) {
        TextField(
            value = value,
            onValueChange = onDescriptionChanged,
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.Black,
                backgroundColor = Color.Transparent,
                cursorColor = Orange,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                capitalization = KeyboardCapitalization.Sentences
            )
        )
    }
}

@Composable
fun NameTextField(value: String, onNameChanged: (String) -> Unit) {
    TextField(
        value = value,
        onValueChange = onNameChanged,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 0.dp),
        singleLine = true,
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.Black,
            cursorColor = Orange,
            focusedIndicatorColor = Orange,
            unfocusedIndicatorColor = Orange
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            capitalization = KeyboardCapitalization.Sentences
        )
    )
}

@Composable
fun Categories(taskViewModel: AddTaskViewModel) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
    ) {
        IconItem(
            icon = Icons.Filled.Person,
            isSelected = taskViewModel.taskUiState.selectedCategory == CategoryTypes.PERSONAL,
            onIconSelected = { taskViewModel.setSelectedCategory(CategoryTypes.PERSONAL) }
        )
        IconItem(
            Icons.Filled.ShoppingCart,
            isSelected = taskViewModel.taskUiState.selectedCategory == CategoryTypes.SHOP,
            onIconSelected = { taskViewModel.setSelectedCategory(CategoryTypes.SHOP) })
        IconItem(
            Icons.Filled.Call,
            isSelected = taskViewModel.taskUiState.selectedCategory == CategoryTypes.CALL,
            onIconSelected = { taskViewModel.setSelectedCategory(CategoryTypes.CALL) })
        IconItem(
            Icons.Filled.Check,
            isSelected = taskViewModel.taskUiState.selectedCategory == CategoryTypes.TODO,
            onIconSelected = { taskViewModel.setSelectedCategory(CategoryTypes.TODO) })
    }

}


@Composable
fun TitleItem(title: String, modifier: Modifier) {
    Text(
        text = title,
        modifier = Modifier
            .padding(vertical = 8.dp)
            .then(modifier),
        style = TextStyle(
            color = Color.Gray,
            fontWeight = FontWeight.ExtraLight,
            fontSize = 18.sp
        )
    )
}


@Composable
fun BigTitleItem(
    title: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = title,
        modifier = modifier,
        style = TextStyle(
            color = Color.Black,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 32.sp
        )
    )
}


@Composable
fun IconItem(icon: ImageVector, isSelected: Boolean, onIconSelected: () -> Unit) {
    val backgroundModifier = Modifier
        .background(
            shape = CircleShape,
            brush = Brush.linearGradient(listOf(Orange, Color.Blue))
        )
    val modifier = if (isSelected) {
        Modifier
            .border(
                width = 2.dp,
                brush = Brush.linearGradient(listOf(Color.Black, Color.Green)),
                shape = CircleShape
            )
            .padding(6.dp)
            .then(backgroundModifier)

    } else backgroundModifier

    IconButton(
        onClick = onIconSelected,
        modifier = modifier
    ) {
        Icon(imageVector = icon, contentDescription = "Task Category Icon")
    }

}

@Preview
@Composable
fun AddTaskScreenPreview() {
    AddTaskScreen(navigateDetailScreen = {}, viewModel = AddTaskViewModel())
}

