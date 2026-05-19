package com.example.todoapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.SimpleDateFormat
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TodoListPage(viewModel: TodoViewModel){
    val todos by viewModel.todoList.observeAsState()
    var inputText by remember {
        mutableStateOf("")
        }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
            .statusBarsPadding()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = inputText,
                onValueChange = {inputText = it},
                label = { Text(text = "Enter todo")},
                modifier = Modifier.weight(0.7f))
            Button(
                onClick = {
                    viewModel.addTodo(inputText)
                    inputText = ""
                },
                ){
                Text(
                    text = "Add",
                    color = Color.White,
                    fontSize = 15.sp
                )
            }
        }
        todos?.let{
            LazyColumn(
                content = {
                    itemsIndexed(it){ index: Int, item: Todo ->
                        TodoItem(item= item)

                    }
                }
            )
        }?:
            Text(
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                text = "No items yet!",
                color = Color.LightGray,
                fontSize = 15.sp,
            )



    }
}

@Composable
fun TodoItem(item: Todo) {
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(MaterialTheme.colorScheme.primary)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

    Column(
        modifier = Modifier.weight(1f) ){
        Text(
            text = SimpleDateFormat("yyyy-MM-dd").format(item.createdAt),
            color = Color.LightGray,
            fontSize = 10.sp
        )
        Text(
            text = item.title,
            color = Color.White,
            fontSize = 15.sp
        )
    }
        IconButton(
            onClick = {}) {
            Icon(
                painter = painterResource(id = R.drawable.outline_delete_24),
                contentDescription = "delete",
                tint = Color.White)
        }
    }
}
