package src.com.library.lab03;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String memberId;
    private String name;


    private List<LibraryItem> borrowedItems;

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.borrowedItems = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public boolean canBorrow() {
        return borrowedItems.size() < 3;
    }

    public void addItem(LibraryItem item) {
        borrowedItems.add(item);
    }

    public void removeItem(LibraryItem item) {
        borrowedItems.remove(item);
    }
}