package service;

import java.util.ArrayList;
import java.util.List;

import dao.MainDao;
import database.Customer;
import database.HotelRoom;

public class CustomerService {
	private static MainDao mainDao;
	private static CustomerService customerService;
	public static CustomerService getInstance() {
		if (customerService == null) {
			customerService = new CustomerService();
		}
		return customerService;
	}
	
	public CustomerService() {
		mainDao = MainDao.getInstance();
	}
	
	/** �ش� roomType�� ����ִ� �� ���� ��ȯ�մϴ�.
	 * <p>
	 * @param roomType - 0=NormalRoom, 1=SuiteRoom, 2=LuxuyRoom
	 * <p>
	 * GlobalData.roomList�� 3���� �� ������, 4���� �� ������ ���� 3*4������ 2���� �迭�Դϴ�.<p>
	 * ��, roomType�� GlobalData.roomList�� ù��° ���� �ε����Դϴ�.
	 */
	public int roomTypeIsAvailable(int roomType) {
//		for(int i=0; i<4; i++) {
//			if(GlobalData.roomList[roomType][i].getStat().getCode() == 1) {
//				num++;
//			}
//		}
		List<HotelRoom> rooms = mainDao.getAllRoomInfo();
		int num=0;
		for(HotelRoom room : rooms) {
			if(room.getStat().getCode() == 1)
				num++;
		}
		return num;
	}
	
	/** GlobalData.roomList���� roomType�� �´� ��濡 ������ ������ �ֽ��ϴ�.
	 * <p>
	 * ������ ������ ����ִ� �� �� �ε����� ���� ���� �濡 ���� �˴ϴ�.
	 * ������ ������ ���Ҿ� ���� stat�� BOOKING���� ����˴ϴ�.
	 * <p>
	 * @param roomType - 0=NormalRoom, 1=SuiteRoom, 2=LuxuyRoom
	 * @param customer - �����ϴ� �� ����
	 * <p>
	 * GlobalData.roomList�� 3���� �� ������, 4���� �� ������ ���� 3*4������ 2���� �迭�Դϴ�.<p>
	 * ��, roomType�� GlobalData.roomList�� ù��° ���� �ε����Դϴ�.
	 */
	public void bookingRoom(int roomType, Customer customer) {
//		int roomNum;
//		for(roomNum=0; roomNum<4; roomNum++) {
//			if(GlobalData.roomList[roomType][roomNum].getStat().getCode() == 1) {
//				break;
//			}
//		}
//		GlobalData.roomList[roomType][roomNum].setCustomer(customer);
//		GlobalData.roomList[roomType][roomNum].setStat(RoomStatEnum.BOOKING);
//		// DAOȣ���ؼ� ���� ����
	}
	
	/** �Է��� ��ȭ��ȣ�� ����� ��� ���� ��ȣ�� ��ȯ�մϴ�.
	 * <p>
	 * @param phone - �� ��ȣ
	 * @return result - �� ��ȣ�� ����� Integer List
	 */
	public List<Integer> getBokingRoomByPhone(String phone) {
		List<Integer> result = new ArrayList<>();
//		for(HotelRoom[] room1 : GlobalData.roomList) {
//			for(HotelRoom room2 : room1) {
//				if(room2.getCustomer() != null) {
//					if (phone.equals(room2.getCustomer().getPhone())) {
//						result.add(room2.getRoomNum());
//					}
//				}
//			}
//		}
		List<HotelRoom> rooms = mainDao.getAllRoomInfo();
		for(HotelRoom room : rooms) {
			if(room.getCustomer() != null && room.getCustomer().getPhone() == phone)
				result.add(Integer.parseInt(room.getCustomer().getPhone()));
		}
		
		return result;
	}
	
	/** �Է¹��� ���� ���� null�� �ٲٰ�, stat�� AVAILABLE�� �ʱ�ȭ�մϴ�.
	 * <p>
	 * @param roomType - 0=NormalRoom, 1=SuiteRoom, 2=LuxuyRoom
	 * @param roomNum - �ش� Ÿ���� ���° ������
	 * <p>
	 * GlobalData.roomList�� 3���� �� ������, 4���� �� ������ ���� 3*4������ 2���� �迭�Դϴ�.<p>
	 * ��, roomType�� GlobalData.roomList�� ù��° ���� �ε����̰�,<p>
	 * roomNum�� GlobalData.roomList�� �ι�° ���� �ε����Դϴ�.
	 */
	public void unbookingRoom(int roomType, int roomNum) {
		mainDao.delBooking(roomType*100 + roomNum);
//		GlobalData.roomList[roomType][roomNum].setCustomer(null);
//		GlobalData.roomList[roomType][roomNum].setStat(RoomStatEnum.AVAILABLE);
	}
	
	/** �Է¹��� ���� ���� null�� �ٲٰ�, stat�� AVAILABLE�� �ʱ�ȭ�մϴ�.
	 * <p>
	 * @param roomNumber - Hotelroom.getRoomNum() �ϸ� ������ 3���� String�Դϴ�.
	 * �ڵ����� roomType��, roomNum���� ��ȯ�մϴ�.
	 */
	public void unbookingRoom(String roomNumber) {
		mainDao.delBooking(Integer.parseInt(roomNumber));
//		int roomType = (Integer.parseInt(roomNumber.split("0")[0]))-1;
//		int roomNum = (Integer.parseInt(roomNumber.split("0")[1]))-1;
//		GlobalData.roomList[roomType][roomNum].setCustomer(null);
//		GlobalData.roomList[roomType][roomNum].setStat(RoomStatEnum.AVAILABLE);
	}
}