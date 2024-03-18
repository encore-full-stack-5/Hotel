package main;

import controller.CustomerController;
import database.NormalRoom;
import database.RoomStatEnum;
import global.GlobalData;

public class CustomerMain {

	public static void main(String[] args) {
//		GlobalData.roomList[0][0] = new NormalRoom(101, RoomStatEnum.AVAILABLE);
//		GlobalData.roomList[0][1] = new NormalRoom(102, RoomStatEnum.AVAILABLE);
//		GlobalData.roomList[0][2] = new NormalRoom(103, RoomStatEnum.BOOKING);
//		GlobalData.roomList[0][3] = new NormalRoom(104, RoomStatEnum.AVAILABLE);
//		GlobalData.roomList[1][0] = new NormalRoom(201, RoomStatEnum.CLEANING);
//		GlobalData.roomList[1][1] = new NormalRoom(202, RoomStatEnum.AVAILABLE);
//		GlobalData.roomList[1][2] = new NormalRoom(203, RoomStatEnum.BOOKING);
//		GlobalData.roomList[1][3] = new NormalRoom(204, RoomStatEnum.BOOKING);
//		GlobalData.roomList[2][0] = new NormalRoom(301, RoomStatEnum.BOOKING);
//		GlobalData.roomList[2][1] = new NormalRoom(302, RoomStatEnum.AVAILABLE);
//		GlobalData.roomList[2][2] = new NormalRoom(303, RoomStatEnum.AVAILABLE);
//		GlobalData.roomList[2][3] = new NormalRoom(304, RoomStatEnum.CLEANING);
		CustomerController customerController = CustomerController.getInstance();
		customerController.start();
		

	}

}
