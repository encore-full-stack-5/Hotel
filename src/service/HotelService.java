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
			System.out.println("寞 廓��: " + list.get(i).getRoomNum() + "��");
			
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
		
		System.out.println("蕨擒陛棟 : ﹤  蕨擒 醞 : 〡   癱熨 醞 : ﹥  羶模 醞 : 〩  ");
		System.out.println("忙天天天天天天天天天天天天天天天天天-天天天天天天天天天天天天天天天天忖");
		System.out.println("| \t\t1�αt2�αt3�αt4�αt|");
		
		for(int i = list.length-1; i >= 0; i--) {
//			
			if(i == 0) System.out.print("|橾奩瑛 1類\t");
			else if(i == 1) System.out.print("|蝶嬪お瑛 2類\t");
			else System.out.print("|楣敷葬瑛 3類\t");
			
			for(int j = 0; j < list[i].length; j++) {
				if(list[i][j].getStat() == RoomStatEnum.AVAILABLE)
					System.out.print("﹤\t");
				else if(list[i][j].getStat() == RoomStatEnum.BOOKING)
					System.out.print("〡\t");
				else if(list[i][j].getStat() == RoomStatEnum.STAYING)
					System.out.print("﹥\t");
				else
					System.out.print("〩\t");
			}
			System.out.println("|");
		}
		System.out.println("戌天天天天天天天天天天天天天天天天天-天天天天天天天天天天天天天天天天戎");
		
//		for(int i = rooms.size()-1; i >= 0; i--) {
//			
//			if(i == 0) System.out.print("|橾奩瑛 1類\t");
//			else if(i == 4) System.out.print("|蝶嬪お瑛 2類\t");
//			else if(i == 8) System.out.print("|楣敷葬瑛 3類\t");
//			
//			if(rooms.get(i).getStat() == RoomStatEnum.AVAILABLE)
//				System.out.print("﹤\t");
//			else if(rooms.get(i).getStat() == RoomStatEnum.BOOKING)
//				System.out.print("〡\t");
//			else if(rooms.get(i).getStat() == RoomStatEnum.STAYING)
//				System.out.print("﹥\t");
//			else
//				System.out.print("〩\t");
//			
//			if(i % 4 == 3) System.out.println("|");
//		}
//		System.out.println("戌天天天天天天天天天天天天天天天天天-天天天天天天天天天天天天天天天天戎");
		
//		System.out.println("蕨擒陛棟 : ﹤  蕨擒 醞 : 〡   癱熨 醞 : ﹥  羶模 醞 : 〩  ");
//		System.out.println("忙天天天天天天天天天天天天天天天天天-天天天天天天天天天天天天天天天天忖");
//		System.out.println("| \t\t1�αt2�αt3�αt4�αt|");
//		for(int i = GlobalData.roomList.length-1; i >=0; i--) {
//			
//			if(i == 0) System.out.print("|橾奩瑛 1類\t");
//			else if(i == 1) System.out.print("|蝶嬪お瑛 2類\t");
//			else System.out.print("|楣敷葬瑛 3類\t");
//			
//			for(int j = 0; j < GlobalData.roomList[0].length; j++) {
//				if(GlobalData.roomList[i][j].getStat() == RoomStatEnum.AVAILABLE)
//					System.out.print("﹤\t");
//				else if(GlobalData.roomList[i][j].getStat() == RoomStatEnum.BOOKING)
//					System.out.print("〡\t");
//				else if(GlobalData.roomList[i][j].getStat() == RoomStatEnum.STAYING)
//					System.out.print("﹥\t");
//				else
//					System.out.print("〩\t");
//			}
//			System.out.println("|");
//		}
//		System.out.println("戌天天天天天天天天天天天天天天天天天-天天天天天天天天天天天天天天天天戎");
	}
	
	public void checkOutRoom(String roomNum) {
		RoomStatEnum room = dao.getRoom(roomNum);
		
		if(room == RoomStatEnum.STAYING) {
			dao.setRoomStat(Integer.parseInt(roomNum), 4);
//			GlobalData.roomList[i][j].setStat(RoomStatEnum.CLEANING);
			System.out.println("羹觼 嬴醒 腑蝗棲棻.");
//			GlobalData.roomList[i][j].setCleanTime(LocalDateTime.now());
			roomState();
		} else if(room == RoomStatEnum.AVAILABLE)
			System.out.println("羶模蒂 葆耀 寞殮棲棻.");
		else
			System.out.println("羶模 醞 殮棲棻.");
		
//		String[] index = roomNum.split("0");
//		
//		int i = Integer.parseInt(index[0]) - 1;
//		int j = Integer.parseInt(index[1]) - 1;
//		
//		if(GlobalData.roomList[i][j].getStat() == RoomStatEnum.STAYING) {
////			dao.setRoomStat(Integer.parseInt(roomNum), 4);
//			GlobalData.roomList[i][j].setStat(RoomStatEnum.CLEANING);
//			System.out.println("羹觼 嬴醒 腑蝗棲棻.");
//			GlobalData.roomList[i][j].setCleanTime(LocalDateTime.now());
//			roomState();
//		} else if(GlobalData.roomList[i][j].getStat() == RoomStatEnum.AVAILABLE)
//			System.out.println("羶模蒂 葆耀 寞殮棲棻.");
//		else
//			System.out.println("羶模 醞 殮棲棻.");
	}
	
	public void checkInRoom(String name, String phone) {
		String p = phone.split("-")[2];
		List<HotelRoom> rooms = dao.getAllRoomInfo();
		
		for(int i = 0; i < rooms.size(); i++) {
			if(rooms.get(i).getCustomer() != null) {
				if(name.equals(rooms.get(i).getCustomer().getName())) {
					if(p.equals(rooms.get(i).getCustomer().getPhone().split("-")[2])) {
						System.out.println("闌剪遴 癱熨 腎褊衛螃~*^^*\n");
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
//							System.out.println("闌剪遴 癱熨 腎褊衛螃~*^^*\n");
//							GlobalData.roomList[i][j].setStat(RoomStatEnum.STAYING);
//						}
//					}	
//				}
//			}
//		}
		
	}
}
