package  jp.bcat;
import  java.io.*;
import  java.text.SimpleDateFormat;
import  java.util.*;

public  class  BookCatalog{
     static  final  String  CATALOG_FILE_NAME = "books.ser";
     protected  Hashtabler  books  =  new  Hashtable();

     public  BookCatalog(){
         load();
     }

     protected  synchronized  void  load(){
          try{
              ObjectInputStream  in = new  ObjectInputStream(
                  new  FileInputStream(CATALOG_FILE_NAME));
              books  =  (HashTable)in.readObject();
              in.close();
          }catch(FileNotFoundException e){
              // ファイルがない場合は何もしない
          }catch(Exception e){
              e.printStackTrace();
          }
     }

     protected  synchronized  void  save(){
         try{
             ObjectOutputStream out = new ObjectOutputStream(
                 new  FileOutputStream(CATALOG_FILE_NAME));
                 out.writeObject(books);
                 out.close();
         }catch(Exception e){
             e.printStackTrace();
         }
     }

     public  Book  getBook( String  bookId){
         return (Book)books.get(bookId);
     }

     public  Book[]  getBooks(){
         Book  resultArray[]  =  new  Book[books.size()];
         books.values().toArray(resultArray);
         return  resultArray;
     }

     protected  String  createUniqueBookId(){
         Date  now = new Date();
         String  id;
         id  =  new  SimpleDateFormat("yyyyMMddHH").format(now);
         while( getBook(id) != null ){
             int  intId  =  Integer.parseInt(id);
             id = Integer.toString( intId + 1 );
         }
         return  id;
     }

     public  synchronized  Book  addBook( Book book ){
         String  id  =  book.getBookId();
         if( id  ==  null  ||  books.containsKey( id )){
             id = createUniqueBookId();
             book.setBookId( id );
         }
         books.put( id, book);
         save();
         return book;
     }

     public  void  deleteBooks( String  bookId ){
         books.remove( bookId );
         save();
     }
     public  void  deleteTitle( String  title ){
        books.remove( title );
        save();
     }
     public  void  deleteAuthor( String   ){
      .remove();
      save();
}
     public  void  deleteTranslator( String   ){
      .remove();
      save();
}
     public  void  deletePublisher( String   ){
      .remove();
      save();
}
     public  void  deletePublishingDate( String   ){
      .remove();
      save();
}
     public  void  deleteCode( String   ){
      .remove();
      save();
}
     public  void  deleteMemo( String   ){
      .remove();
      save();
}
     public  void  deleteKeyword( String   ){
      .remove();
      save();
}
     public  void  deleteStatus( String   ){
      .remove();
      save();
}
     public  void  deleteDataCreator( String   ){
      .remove();
      save();
}
     public  void  deleteDataCreatedDate( String   ){
          .remove();
          save();
    }
}