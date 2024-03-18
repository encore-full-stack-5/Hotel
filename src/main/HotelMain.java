package main;

import controller.HotelController;
import database.Customer;
import database.NormalRoom;
import database.RoomStatEnum;
import global.GlobalData;

public class HotelMain {
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
//		
//		Customer customer = new Customer("빌게이츠", 2, "02-987-6543");
//		GlobalData.roomList[0][2].setCustomer(customer);
//		customer = new Customer("스티브잡스", 1, "010-7777-7777");
//		GlobalData.roomList[1][2].setCustomer(customer);
//		customer = new Customer("워랜버핏", 3, "011-111-1234");
//		GlobalData.roomList[1][3].setCustomer(customer);
//		customer = new Customer("박성무", 3, "8210-999-1111");
//		GlobalData.roomList[2][0].setCustomer(customer);
		
		HotelController controller = HotelController.getInstance();	
		controller.start();
	}
	
	
}