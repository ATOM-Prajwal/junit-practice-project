package com.nttdata.data.api;

import java.util.List;

//create ToDoServiceStub
//Test ToDoBusinessImpl using ToDoServiceSTub
public interface TodoService {
 public List<String> retriveToDos(String user);
 public void deleteToDo(String todo);
}
