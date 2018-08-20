/**
 * Date: 2018/08/20
 * Project: Contact manager
 */

/**
 * class store the contact information
 */
class Contact{
    String name;
    String email;
    String phoneNumber;
}

/**
 * class manage the contact information
 */
class ContactsManager {
    // contact field
    Contact [] myFrieds;

    int friendsCount;

    // constructor

    ContactsManager(){
        this.friendsCount = 0;
        this.myFrieds = new Contact[500];
    }

    // method, add contact
    void addContact(Contact contact){
        myFrieds[friendsCount] = contact;
        friendsCount ++;
    }

    // search the contact
    Contact searchContact(String searchName){
        for(int i=0; i<friendsCount; i++){
            if(myFrieds[i].name.equals(searchName)){
                return myFrieds[i];
            }
        }
        return null;
    }
}

public class Main {

    // main class and method

    public static void main(String [] args){
        // create the contacts manager object
        ContactsManager myContactManager = new ContactsManager();

        // try to create the contact test
        Contact friendTest = new Contact();

        // set the field value
        friendTest.name = "Test";
        friendTest.phoneNumber = "0012345";

        // add test to contacts manager
        myContactManager.addContact(friendTest);

        // add another contact
        Contact anotherFriend = new Contact();

        anotherFriend.name = "Test1";
        anotherFriend.phoneNumber = "234545";

        // add another to contacts manager
        myContactManager.addContact(anotherFriend);

        // search contact
        Contact result = myContactManager.searchContact("Test");
        System.out.println(result.phoneNumber);
        }
}
