package com.kodilla.patterns.prototype;

import org.junit.Assert;
import org.junit.Test;

import java.util.stream.IntStream;

public class BoardTestSuite {
    @Test
    public void testToString(){
        //given
            //creating the TaskList for To do
        TasksList listToDo = new TasksList("To do Tasks");
        IntStream.iterate(1, n -> n+1)
                .limit(10)
                .forEach(n -> listToDo.getTasks().add(new Task("To Do Task number " + n)));

            //creating the TaskList for task in progress
        TasksList listInProgress  = new TasksList("In progress Tasks");
        IntStream.iterate(1, n -> n+1)
                .limit(10)
                .forEach(n -> listInProgress.getTasks().add(new Task("In Progress Task number " + n)));
            //creating the TaskList for done task
        TasksList listDone  = new TasksList("Done Tasks");
        IntStream.iterate(1, n -> n+1)
                .limit(10)
                .forEach(n -> listDone.getTasks().add(new Task("Done Task number " + n)));
            //creating the Board and assigning the lists
        Board board = new Board("Project number 1");
        board.getLists().add(listToDo);
        board.getLists().add(listInProgress);
        board.getLists().add(listDone);

        //making a shallow copy of object board
        Board clonedBoard = null;
        try{
            clonedBoard = board.shallowCopy();
            clonedBoard.setName("Project number 2");
        } catch (CloneNotSupportedException e){
            System.out.println(e);
        }

        //making a deep copy of object board
        Board deepCopyBoard = null;
        try {
            deepCopyBoard = board.deepCopy();
            deepCopyBoard.setName("Project number 3");
        } catch (CloneNotSupportedException e){
            System.out.println(e);
        }

        //when
        board.getLists().remove(listToDo);
        //then
        System.out.println(board);
        System.out.println(clonedBoard);
        System.out.println(deepCopyBoard);
        Assert.assertEquals(2, board.getLists().size());
        Assert.assertEquals(2, clonedBoard.getLists().size());
        Assert.assertEquals(3, deepCopyBoard.getLists().size());
        Assert.assertEquals(clonedBoard.getLists(), board.getLists());
        Assert.assertNotEquals(deepCopyBoard.getLists(), board.getLists());
    }
}
