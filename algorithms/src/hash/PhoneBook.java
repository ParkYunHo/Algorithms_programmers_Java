package hash;

public class PhoneBook {
	public static boolean phoneBook_method(String[] phone_book) {
		boolean answer = false;
		
		int phone_book_lens = phone_book.length;
		for(int i=0; i<phone_book_lens; i++) {
			for(int j=0; j<phone_book_lens; j++) {
				if(i==j) continue;
				if(phone_book[j].contains(phone_book[i])) {
					return true;
				}
			}
		}
        
        return answer;
    }
}
