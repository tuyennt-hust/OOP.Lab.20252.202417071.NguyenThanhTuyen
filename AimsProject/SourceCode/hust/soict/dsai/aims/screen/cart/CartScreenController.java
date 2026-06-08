package hust.soict.dsai.aims.screen.cart;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.TextField;
import javafx.scene.control.RadioButton;

public class CartScreenController {
private Cart cart;

@FXML
private Button btnPlay;

@FXML
private Button btnRemove;

@FXML
private TableColumn<Media, String> colMediaCategory;

@FXML
private TableColumn<Media, Float> colMediaCost;

@FXML
private TableColumn<Media, String> colMediaTitle;

@FXML
private ToggleGroup filterCategory;

@FXML
private TableView tblMedia;

@FXML
private TextField tfFilter;

@FXML
private RadioButton radioBtnFilterId;

@FXML
private RadioButton radioBtnFilterTitle;

@FXML
private javafx.scene.control.Label lblTotal;

@FXML
private javafx.scene.control.Button btnPlaceOrder;

public CartScreenController(Cart cart) {
super();
this.cart = cart;
}  
@FXML
private void initialize() {
colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));

if (cart != null && cart.getItemsOrdered() != null) {
    FilteredList<Media> filteredData = new FilteredList<>(cart.getItemsOrdered(), p -> true);
    tblMedia.setItems(filteredData);

    tfFilter.textProperty().addListener(new ChangeListener<String>() {
        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            showFilteredMedia(newValue, filteredData);
        }
    });
}

btnPlay.setVisible(false);
btnRemove.setVisible(false);
btnRemove.setOnAction(this::btnRemovePressed);
btnPlay.setOnAction(this::btnPlayPressed);

tblMedia.getSelectionModel().selectedItemProperty().addListener(
    new ChangeListener<Media>() {
        @Override
        public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
            if (newValue != null) {
                updateButtonBar(newValue);
            }
        }
    }
);
updateTotal();
cart.getItemsOrdered().addListener((javafx.collections.ListChangeListener) c -> {
updateTotal();
});
}

void updateButtonBar(Media media) {
btnRemove.setVisible(true);
if (media instanceof Playable) {
btnPlay.setVisible(true);
} else {
btnPlay.setVisible(false);
}
}

@FXML
void btnRemovePressed(ActionEvent event) {
Media media = (Media) tblMedia.getSelectionModel().getSelectedItem();
cart.removeMedia(media);
}

@FXML
void btnPlayPressed(ActionEvent event) {
Media media = (Media) tblMedia.getSelectionModel().getSelectedItem();
Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setTitle("play media");
alert.setHeaderText("playing " + media.getTitle());
alert.setContentText("media is playing now...");
alert.showAndWait();
}
void showFilteredMedia(String newValue, FilteredList filteredData) {
filteredData.setPredicate(media -> {
if (newValue == null || newValue.isEmpty()) {
return true;
}

    if (radioBtnFilterId != null && radioBtnFilterId.isSelected()) {
        try {
            int id = Integer.parseInt(newValue);
            return ((Media) media).getId() == id;
        } catch (NumberFormatException e) {
            return false;
        }
    } else {
        String lowerCaseFilter = newValue.toLowerCase();
        if (((Media) media).getTitle() != null && ((Media) media).getTitle().toLowerCase().contains(lowerCaseFilter)) {
            return true;
        }
        return false;
    }
});
}
void updateTotal() {
float total = 0;
for (Media media : cart.getItemsOrdered()) {
total += media.getCost();
}
lblTotal.setText(total + " $");
}

@FXML
void btnPlaceOrderPressed(javafx.event.ActionEvent event) {
javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION);
alert.setTitle("Place Order");
alert.setHeaderText("Order created successfully!");
alert.setContentText("Your cart has been cleared.");
alert.showAndWait();
cart.getItemsOrdered().clear();
}
@FXML
void btnViewStorePressed(javafx.event.ActionEvent event) {
System.out.println("se chuyen sang man hinh store sau");
}
}