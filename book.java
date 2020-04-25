package Java2_06_07;

public class book {
    public static class Book {
        private int id, qty;
        private String title, author, category, importdate;
        private float price;

        public float getPrice() {
            return price;
        }

        public int getId() {
            return id;
        }

        public int getQty() {
            return qty;
        }

        public String getAuthor() {
            return author;
        }

        public String getCategory() {
            return category;
        }

        public String getImportdate() {
            return importdate;
        }

        public String getTitle() {
            return title;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public void setImportdate(String importdate) {
            this.importdate = importdate;
        }

        public void setPrice(float price) {
            this.price = price;
        }

        public void setQty(int qty) {
            this.qty = qty;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    ", author='" + author + '\'' +
                    ", category='" + category + '\'' +
                    ", price=" + price +
                    ", qty=" + qty +
                    ", importdate='" + importdate + '\'' +
                    '}';
        }
    }
}
