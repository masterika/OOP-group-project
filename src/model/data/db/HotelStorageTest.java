package model.data.db;

import static org.junit.Assert.*;
import helper.StringToMD5;

import java.util.ArrayList;

import model.data.users.Hotel;

import org.junit.Test;

public class HotelStorageTest {

	HotelStorage a = new HotelStorage();
	@Test
	public void test() {
		
		//Hotel hotel = a.loadHotel("Hotel2");
		ArrayList<Hotel> list =  a.getHotelsFromDB();
		//System.out.println(a.getHotelsFromDB().size());
		System.out.println(list.get(0).getName());
		System.out.println(list.size());

		for (Hotel h : list) {
			System.out.println(h.getName());
		}
		
	/*	for (int i = 0; i < a.getHotelsFtomDB().size(); i++) {
			System.out.println(a.getHotelsFtomDB().get(i).getName());
		}
		*/
		//assert(hotel != null);
	}
}
