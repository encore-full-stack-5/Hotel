package thread;

import java.time.LocalDateTime;
import java.util.List;

import dao.MainDao;

public class CleaningThread extends Thread {
	final int NEED_CLEENING_TIME = 10;	// second
	final int UPDATE_TIME = 1000;		// Millisecond
	
	public void run() {
		MainDao mainDao = MainDao.getInstance();
		while (true) {
			List<String[]> rooms = mainDao.getCleaningRoom();
			for(String[] room : rooms) {
				if(LocalDateTime.parse(room[3]).plusSeconds(NEED_CLEENING_TIME).isAfter(LocalDateTime.now())){
					mainDao.setRoomStat(Integer.parseInt(room[0]), Integer.parseInt(room[1]));
				}
			}
			
			try {
				sleep(UPDATE_TIME);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}