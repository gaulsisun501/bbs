package test3;

import java.util.ArrayList;

public class SampleMain {

	public static void main(String[] args) {
				
		// 데이터베이스 액세스 
		SampleDAO sampleDao = new SampleDAO();
		ArrayList<SampleDTO> sampleDtos = sampleDao.findAll();
		
		// 결과 표시 
		for(SampleDTO s : sampleDtos) {
			System.out.println("id: " + s.getId());
			System.out.println("name: " + s.getName());
			System.out.println("price: " + s.getPrice());
			System.out.println();
		}
	}
}
