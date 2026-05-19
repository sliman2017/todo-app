package com.example.todoapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todoapp.ui.Todo
import com.example.todoapp.ui.getFakeTodos
import java.text.SimpleDateFormat

@Composable
fun TodoListPage(){
    val todos = getFakeTodos()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        LazyColumn(
            content = {
                itemsIndexed(todos){ index: Int, item: Todo ->
                    TodoItem(item= item)

                }
            }
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
            .padding(16.dp)
    ) {

    Column{
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
    }
}
