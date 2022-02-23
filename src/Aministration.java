import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Aministration {
    public static ArrayList<Book> getBooksForPublishingRetailerID(int retailerID, ArrayList<PublishingRetailer> retailers) {
        //lista carti rezultate
        ArrayList <Book> resultBooks = new ArrayList<Book>();
        for (PublishingRetailer retailer : retailers) {
           if (retailer.getID() == retailerID) {
               for (IPublishingArtifact aux : retailer.getPublishingArtifacts()) {
                   if (aux instanceof Book) {
                       Book copy = (Book)aux;
                       resultBooks.add(copy);
                   }
                   else if (aux instanceof EditorialGroup) {
                       ArrayList<Book> booksGroup = ((EditorialGroup)aux).getBooks();
                       for (Book book : booksGroup) {
                           //nu exista carte
                           int exist = 1;
                           for (Book result : resultBooks) {
                               //exista carte
                               if (book.getID() == result.getID()) {
                                   exist = 0;
                                   break;
                               }
                           }
                           if (exist == 1) {
                               resultBooks.add(book);
                           }
                       }
                   }
                   else if (aux instanceof PublishingBrand) {
                       ArrayList<Book> booksBrand = ((PublishingBrand)aux).getBooks();
                       for (Book book : booksBrand) {
                           //nu exista carte
                           int exist = 1;
                           for (Book result : resultBooks) {
                               if (book.getID() == result.getID()) {
                                   exist = 0;
                                   break;
                               }
                           }
                           if (exist == 1) {
                               resultBooks.add(book);
                           }
                       }
                   }
               }
           }
        }
        return resultBooks;
    }
    public static ArrayList<Language> getLanguagesForPublishingRetailerID(int retailerID, ArrayList<PublishingRetailer> retailers, ArrayList<Language> languages) {
        //lista limbi rezultate
        ArrayList<Integer> resultIDs = new ArrayList<Integer>();
        for (PublishingRetailer retailer : retailers) {
            if (retailer.getID() == retailerID) {
                for (IPublishingArtifact aux : retailer.getPublishingArtifacts()) {
                    if (aux instanceof Book) {
                        Book copy = (Book)aux;
                        int exist = 1;
                        for (Integer id : resultIDs) {
                            if (copy.getLanguageID() == id) {
                                exist = 0;
                                break;
                            }
                        }
                        if (exist == 1) {
                            resultIDs.add(copy.getLanguageID());
                        }
                    }
                    else if (aux instanceof EditorialGroup) {
                        ArrayList<Book> bookGroup = ((EditorialGroup)aux).getBooks();
                        for (Book book : bookGroup) {
                            int exist = 1;
                            for (Integer id : resultIDs) {
                                if (book.getLanguageID() == id) {
                                    exist = 0;
                                    break;
                                }
                            }
                            if (exist == 1) {
                                resultIDs.add(book.getLanguageID());
                            }
                        }
                    }
                    else if (aux instanceof PublishingBrand) {
                        ArrayList<Book> booksBrand = ((PublishingBrand)aux).getBooks();
                        for (Book book : booksBrand) {
                            int exist = 1;
                            for (Integer id : resultIDs) {
                                if (book.getLanguageID() == id) {
                                    exist = 0;
                                    break;
                                }
                            }
                            if (exist == 1) {
                                resultIDs.add(book.getLanguageID());
                            }
                        }
                    }
                }
            }
        }
        ArrayList<Language> languagesRetailer = new ArrayList<Language>();
        for (Language aux : languages) {
            for (Integer id : resultIDs) {
                if (aux.getID() == id) {
                    languagesRetailer.add(aux);
                }
            }
        }
        return languagesRetailer;
    }
    public static ArrayList<Countries> getCountriesForBookID(int bookID, ArrayList<PublishingRetailer> retailers) {
        ArrayList<Countries> countries = new ArrayList<Countries>();
        for (PublishingRetailer retailer : retailers) {
            for (IPublishingArtifact artifact : retailer.getPublishingArtifacts()) {
                if (artifact instanceof Book) {
                    Book copy = (Book)artifact;
                    if (copy.getID() == bookID) {
                        for (Countries country : retailer.getCountries()) {
                            countries.add(country);
                        }
                        break;
                    }
                }
                else if (artifact instanceof EditorialGroup) {
                    ArrayList<Book> booksGroup = ((EditorialGroup)artifact).getBooks();
                    for (Book book : booksGroup) {
                        if (book.getID() == bookID) {
                            for (Countries country : retailer.getCountries()) {
                                countries.add(country);
                            }
                            break;
                        }
                    }
                }
                else if (artifact instanceof PublishingBrand) {
                    ArrayList<Book> booksGroup = ((PublishingBrand)artifact).getBooks();
                    for (Book book : booksGroup) {
                        if (book.getID() == bookID) {
                            for (Countries country : retailer.getCountries()) {
                                countries.add(country);
                            }
                            break;
                        }
                    }
                }
            }
        }
        return countries;
    }
    public static ArrayList<Book> getCommonBooksForRetailerIDs(int retailerId1, int retailerId2, ArrayList<PublishingRetailer>retailers) {
        ArrayList<Book> commonBooks = new ArrayList<Book>();
        ArrayList<Book> firstRetailer = getBooksForPublishingRetailerID(retailerId1, retailers);
        ArrayList<Book> secondRetailer = getBooksForPublishingRetailerID(retailerId2, retailers);
        for (Book first : firstRetailer) {
            if (secondRetailer.contains(first)) {
                commonBooks.add(first);
            }
        }
        return commonBooks;
    }
    public static ArrayList<Book> getAllBooksForRetailerIDs(int retailerId1, int retailerId2, ArrayList<PublishingRetailer> retailers) {
        ArrayList<Book> firstRetailer = getBooksForPublishingRetailerID(retailerId1, retailers);
        ArrayList<Book> secondRetailer = getBooksForPublishingRetailerID(retailerId2, retailers);
        ArrayList<Book> allBooks = (ArrayList<Book>) firstRetailer.clone();
       for (Book second : secondRetailer) {
           if (allBooks.contains(second) == false) {
                allBooks.add(second);
           }
       }
       return allBooks;
    }
}
