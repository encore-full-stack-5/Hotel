package service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dao.MainDao;
import database.Customer;
import database.HotelRoom;
import database.RoomStatEnum;
import global.GlobalData;

public class HotelService {
	private static HotelService hotelService;
	private final MainDao dao;
	
	public static HotelService getInstance() {
		if(hotelService == null)
			hotelService = new HotelService();
		return hotelService;
	}
	
	private HotelService() {
		dao = MainDao.getInstance();
	}
	
	public void bookingState() {
		List<HotelRoom> list = new ArrayList<HotelRoom>();
		List<HotelRoom> rooms = dao.getAllRoomInfo();
		for(int i = 0; i < rooms.size(); i ++) {
			if(rooms.get(i).getStat().getCode() == 2) {
				list.add(rooms.get(i));
			}
		}
		
		
//		for(int i = 0; i < GlobalData.roomList.length; i++) {
//			for(int j = 0; j < GlobalData.roomList[0].length; j++) {
//				if(GlobalData.roomList[i][j].getCustomer() != null)
//					if(GlobalData.roomList[i][j].getStat() == RoomStatEnum.BOOKING)
//						list.add(GlobalData.roomList[i][j]);
//			}
//		}

		for(int i = 0; i < list.size(); i++) {
			System.out.println("¹æ ¹øÈ£: " + list.get(i).getRoomNum() + "È£");
			
			list.get(i).getCustomer().print();

			System.out.println("--------------------");
		}
	}
	
	public void roomState() {
		HotelRoom[][] list = new HotelRoom[3][4];
		List<HotelRoom> rooms = dao.getAllRoomInfo();
		
		
		for(int i = 0; i < list.length; i++) {
			for(int j = 0; j < rooms.size(); j ++) {
				list[i][j%4] = rooms.get(j+(i*4));
				if(j % 4 == 3) break;
			}
		}
		
		System.out.println("¿¹¾à°¡´É : ¡à  ¿¹¾à Áß : ¢Ã   Åõ¼÷ Áß : ¡á  Ã»¼Ò Áß : ¢Ë  ");
		System.out.println("¦£¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ-¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¦¤");
		System.out.println("| \t\t1È£\t2È£\t3È£\t4È£\t|");
		
		for(int i = list.length-1; i >= 0; i--) {
//			
			if(i == 0) System.out.print("|ÀÏ¹Ý·ë 1Ãþ\t");
			else if(i == 1) System.out.print("|½ºÀ§Æ®·ë 2Ãþ\t");
			else System.out.print("|·°¼Å¸®·ë 3Ãþ\t");
			
			for(int j = 0; j < list[i].length; j++) {
				if(list[i][j].getStat() == RoomStatEnum.AVAILABLE)
					System.out.print("¡à\t");
				else if(list[i][j].getStat() == RoomStatEnum.BOOKING)
					System.out.print("¢Ã\t");
				else if(list[i][j].getStat() == RoomStatEnum.STAYING)
					System.out.print("¡á\t");
				else
					System.out.print("¢Ë\t");
			}
			System.out.println("|");
		}
		System.out.println("¦¦¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ-¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¦¥");
		
//		for(int i = rooms.size()-1; i >= 0; i--) {
//			
//			if(i == 0) System.out.print("|ÀÏ¹Ý·ë 1Ãþ\t");
//			else if(i == 4) System.out.print("|½ºÀ§Æ®·ë 2Ãþ\t");
//			else if(i == 8) System.out.print("|·°¼Å¸®·ë 3Ãþ\t");
//			
//			if(rooms.get(i).getStat() == RoomStatEnum.AVAILABLE)
//				System.out.print("¡à\t");
//			else if(rooms.get(i).getStat() == RoomStatEnum.BOOKING)
//				System.out.print("¢Ã\t");
//			else if(rooms.get(i).getStat() == RoomStatEnum.STAYING)
//				System.out.print("¡á\t");
//			else
//				System.out.print("¢Ë\t");
//			
//			if(i % 4 == 3) System.out.println("|");
//		}
//		System.out.println("¦¦¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ-¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¦¥");
		
//		System.out.println("¿¹¾à°¡´É : ¡à  ¿¹¾à Áß : ¢Ã   Åõ¼÷ Áß : ¡á  Ã»¼Ò Áß : ¢Ë  ");
//		System.out.println("¦£¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ-¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¦¤");
//		System.out.println("| \t\t1È£\t2È£\t3È£\t4È£\t|");
//		for(int i = GlobalData.roomList.length-1; i >=0; i--) {
//			
//			if(i == 0) System.out.print("|ÀÏ¹Ý·ë 1Ãþ\t");
//			else if(i == 1) System.out.print("|½ºÀ§Æ®·ë 2Ãþ\t");
//			else System.out.print("|·°¼Å¸®·ë 3Ãþ\t");
//			
//			for(int j = 0; j < GlobalData.roomList[0].length; j++) {
//				if(GlobalData.roomList[i][j].getStat() == RoomStatEnum.AVAILABLE)
//					System.out.print("¡à\t");
//				else if(GlobalData.roomList[i][j].getStat() == RoomStatEnum.BOOKING)
//					System.out.print("¢Ã\t");
//				else if(GlobalData.roomList[i][j].getStat() == RoomStatEnum.STAYING)
//					System.out.print("¡á\t");
//				else
//					System.out.print("¢Ë\t");
//			}
//			System.out.println("|");
//		}
//		System.out.println("¦¦¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ-¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¦¥");
	}
	
	public void checkOutRoom(String roomNum) {
		RoomStatEnum room = dao.getRoom(roomNum);
		
		if(room == RoomStatEnum.STAYING) {
			dao.setRoomStat(Integer.parseInt(roomNum), 4);
//			GlobalData.roomList[i][j].setStat(RoomStatEnum.CLEANING);
			System.out.println("Ã¼Å© ¾Æ¿ô µÆ½À´Ï´Ù. ¾È³çÈ÷ °¡½Ê½Ã¿À.");
//			GlobalData.roomList[i][j].setCleanTime(LocalDateTime.now());
			roomState();
		} else if(room == RoomStatEnum.AVAILABLE)
			System.out.println("Ã»¼Ò¸¦ ¸¶Ä£ ¹æÀÔ´Ï´Ù.");
		else
			System.out.println("Ã»¼Ò Áß ÀÔ´Ï´Ù.");
		
//		String[] index = roomNum.split("0");
//		
//		int i = Integer.parseInt(index[0]) - 1;
//		int j = Integer.parseInt(index[1]) - 1;
//		
//		if(GlobalData.roomList[i][j].getStat() == RoomStatEnum.STAYING) {
////			dao.setRoomStat(Integer.parseInt(roomNum), 4);
//			GlobalData.roomList[i][j].setStat(RoomStatEnum.CLEANING);
//			System.out.println("Ã¼Å© ¾Æ¿ô µÆ½À´Ï´Ù.");
//			GlobalData.roomList[i][j].setCleanTime(LocalDateTime.now());
//			roomState();
//		} else if(GlobalData.roomList[i][j].getStat() == RoomStatEnum.AVAILABLE)
//			System.out.println("Ã»¼Ò¸¦ ¸¶Ä£ ¹æÀÔ´Ï´Ù.");
//		else
//			System.out.println("Ã»¼Ò Áß ÀÔ´Ï´Ù.");
	}
	
	public void checkInRoom(String name, String phone) {
		String p = phone.split("-")[2];
		List<HotelRoom> rooms = dao.getAllRoomInfo();
		
		for(int i = 0; i < rooms.size(); i++) {
			if(rooms.get(i).getCustomer() != null) {
				if(name.equals(rooms.get(i).getCustomer().getName())) {
					if(p.equals(rooms.get(i).getCustomer().getPhone().split("-")[2])) {
						System.out.println("Áñ°Å¿î Åõ¼÷ µÇ½Ê½Ã¿À~*^^*\n");
						//int stat = RoomStatEnum.STAYING.getCode();
						dao.setRoomStat(rooms.get(i).getRoomNum(),RoomStatEnum.STAYING.getCode());
//						break;
						//GlobalData.roomList[i][j].setStat(RoomStatEnum.STAYING);
					}
				}	
			}
			
		}
		
//		for(int i = 0; i < GlobalData.roomList.length; i++) {
//			for(int j = 0; j < GlobalData.roomList[0].length; j++) {
//				if(GlobalData.roomList[i][j].getCustomer() != null) {
//					if(name.equals(GlobalData.roomList[i][j].getCustomer().getName())) {
//						if(p.equals(GlobalData.roomList[i][j].getCustomer().getPhone().split("-")[2])) {
//							System.out.println("Áñ°Å¿î Åõ¼÷ µÇ½Ê½Ã¿À~*^^*\n");
//							GlobalData.roomList[i][j].setStat(RoomStatEnum.STAYING);
//						}
//					}	
//				}
//			}
//		}
		
	}
}
