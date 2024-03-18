package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import database.Customer;
import database.HotelRoom;
import database.NormalRoom;
import global.GlobalData;
import service.CustomerService;

public class CustomerController {
	// 싱글톤
	private static CustomerController customer = null;
	private static CustomerService customerService = CustomerService.getInstance();

	private CustomerController() {
		// customerService = CustomerService.getInstance();
	}

	public static CustomerController getInstance() {
		if (customer == null) {
			customer = new CustomerController();
		}
		return customer;
	}
	// 입력

	Scanner sc = new Scanner(System.in);
	int choose;

	public void start() {
		while (true) {
			try {
				System.out.println("원하시는 메뉴를 선택하세요 \n1.객실 예약하기 2. 예약 객실 취소하기 3. 방 정보 열람하기");
				choose = Integer.parseInt(sc.nextLine());
				if (choose == 1) {
					bookRoom();
				} else if (choose == 2) {
					bookCancel();
				} else if (choose == 3) {
					printRoomInfo();
				} else {
					System.out.println("잘못된 번호입니다. 다시 입력하세요 \n");
				}
			} catch (NumberFormatException e) {
				// TODO: handle exception
				System.out.println("잘못된 번호입니다. 다시 입력하세요 \n");
			}
			

		}
	}

	public void bookRoom() {

		while (true) {
			System.out.println("예약을 희망하시는 객실 유형을 입력하세요\n1. 일반룸 \n2. 스위트룸 \n3. 럭셔리룸 \n4. 뒤로가기");
			choose = Integer.parseInt(sc.nextLine());
			if (choose == 1) {
				System.out.println("일반룸");
				// 일반룸 객실현황 출력
				System.out.println(customerService.roomTypeIsAvailable(0));
				System.out.println("1. 예약하기 2. 뒤로가기");
				choose = Integer.parseInt(sc.nextLine());
				// 1번 선택
				if (choose == 1)
					bookPerson(0);
				// 2번 선택
				else if (choose == 2)
					continue;
			} else if (choose == 2) {
				System.out.println("스위트룸");
				// 스위트룸 객실현황 출력
				System.out.println(customerService.roomTypeIsAvailable(1));
				System.out.println("1. 예약하기 2. 뒤로가기");
				choose = Integer.parseInt(sc.nextLine());
				//sc.nextLine();
				// 1번 선택
				if (choose == 1)
					bookPerson(1);
				// 2번 선택
				else if (choose == 2)
					continue;
			} else if (choose == 3) {
				System.out.println("럭셔리룸");
				// 럭셔리룸 객실현황 출력
				System.out.println(customerService.roomTypeIsAvailable(2));
				System.out.println("1. 예약하기 2. 뒤로가기");
				choose = Integer.parseInt(sc.nextLine());
				//sc.nextLine();
				// 1번 선택
				if (choose == 1)
					bookPerson(2);
				// 2번 선택
				else if (choose == 2)
					continue;
			} else if (choose == 4)
				break;
			else {
				System.out.println("잘못된 번호입니다. 다시 입력하세요");
			}
		}

	}

	public void bookCancel() {
		while(true) {
			System.out.println("핸드폰 번호를 입력하세요 : ");
			String phone = sc.nextLine();
			List<Integer> customerList = customerService.getBokingRoomByPhone(phone);
			if (customerList.size() == 0) {
				System.out.println("해당 번호로 조회되는 방이 없습니다.\n");
				break;
			}
			System.out.println(customerList.toString());
			while (true) {
				System.out.println("취소하실 방번호를 입력하세요 : ");
				String room = sc.nextLine();
				if (customerList.contains(Integer.parseInt(room))) {
					customerService.unbookingRoom(room);
					System.out.println("취소가 완료되었습니다.\n");
					break;
				} else {
					System.out.println("방 번호를 다시 입력하세요\n");
				}
			}
			break;
//			if("101".equals(room)||"102".equals(room)||"103".equals(room)||"104".equals(room)||
//					"201".equals(room)||"202".equals(room)||"203".equals(room)||"204".equals(room)||
//					"301".equals(room)||"302".equals(room)||"303".equals(room)||"304".equals(room)){////////////
//				customerService.unbookingRoom(room);
//				System.out.println("취소가 완료되었습니다.");
//				break;
//			}else {
//				System.out.println("방 번호를 다시 입력하세요");
//				continue;
//			}

		}

	}

	public void printRoomInfo() {
		System.out.println(
				"방 정보\n1. 일반실\t\t2. 스위트룸\t3. 럭셔리룸\n침대개수 : 2\t침대개수 : 3\t침대개수 : 3\n풀장여부 : 무\t풀장여부 : 무\t풀장여부 : 유\n");
//		System.out.println("방 정보 \n\n1. 일반실 \n침대개수 : 2 \n풀장 여부 : 무 \n\n2. 스위트룸 \n침대개수 : 3 \n풀장여부 : 무 \n\n3. 럭셔리룸 \n침대개수 : 3 \n풀장여부 : 유\n");
//		List<HotelRoom> list = new ArrayList<HotelRoom>();
//		System.out.println("방 정보");
//		System.out.println("일반실");
//		System.out.println("침대 개수 : " + list.get(0).getBed());
	}

	public void bookPerson(int roomType) {
		Customer customer;
		String name;
		int family;
		String phone;

		System.out.println("이름을 입력하세요 :");
		name = sc.nextLine();
		System.out.println("인원 수를 입력하세요 :");
		family = Integer.parseInt(sc.nextLine());
		System.out.println("핸드폰 번호를 입력하세요");
		phone = sc.nextLine();
//		System.out.println("이름 : "+name+"\n인원 수 : "+family+"/n핸드폰 번호 : "+phone+"/n위 내용이 맞습니까?");
		System.out.println("예약이 완료되었습니다.\n");
		customer = new Customer(name, family, phone);

		customerService.bookingRoom(roomType, customer);

	}

}