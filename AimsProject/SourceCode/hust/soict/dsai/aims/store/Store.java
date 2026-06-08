package hust.soict.dsai.aims.store;

import java.util.ArrayList;
import hust.soict.dsai.aims.media.Media;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();
    public ArrayList getItemsInStore() {
    	return itemsInStore;
    	}
    public void addMedia(Media media) {
        if (!itemsInStore.contains(media)) {
            itemsInStore.add(media);
            System.out.println(media.getTitle() + " đã được thêm vào cửa hàng.");
        } else {
            System.out.println(media.getTitle() + " đã có sẵn trong cửa hàng.");
        }
    }

    public void removeMedia(Media media) {
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println(media.getTitle() + " đã bị xóa khỏi cửa hàng.");
        } else {
            System.out.println("Không tìm thấy " + media.getTitle() + " trong cửa hàng.");
        }
    }
}
