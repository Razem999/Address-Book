import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

// this is lab 3, testing for more changes
// this is a test
// this is a test from github edit

public class AddressBook extends JFrame implements ActionListener{

    private JList<String> buddyList;
    private DefaultListModel<BuddyInfo> myBuddies;
    private int index;

    public AddressBook() {
        super("Address Book");

        myBuddies = new DefaultListModel<>();
        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);

        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        JMenu editMenu = new JMenu("Edit");
        menuBar.add(editMenu);

        JMenu viewMenu = new JMenu("View");
        menuBar.add(viewMenu);

        JMenuItem item1, item2, item21, item3;

        item1 = new JMenuItem("New Address Book");
        item1.addActionListener(this);
        item1.setActionCommand("item1");
        fileMenu.add(item1);

        item2 = new JMenuItem("Add Buddy");
        item2.addActionListener(this);
        item2.setActionCommand("item2");
        editMenu.add(item2);

        item21 = new JMenuItem("Remove Buddy");
        item21.addActionListener(this);
        item21.setActionCommand("item21");
        editMenu.add(item21);

//        item3 = new JMenuItem("Display Buddies");
//        item3.addActionListener(this);
//        item3.setActionCommand("item3");
//        viewMenu.add(item3);

        this.setLayout(new BorderLayout());

        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public void addBuddy(BuddyInfo aBuddy) {
        if(aBuddy != null) {
            myBuddies.addElement(aBuddy);
        }
    }

    public void duplicateBuddy(BuddyInfo aBuddy) {
        myBuddies.addElement(aBuddy);
    }

    public BuddyInfo removeBuddy(int index) {
        if(index >= 0 && index < myBuddies.size()) {
            myBuddies.removeElement(index);
        }
        return null;
    }

    public void updateList() {
        buddyList.updateUI();
    }

    public void insertList() {
        buddyList = new JList(myBuddies.toArray());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "item1") {
//            this.insertList();

            buddyList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            buddyList.addListSelectionListener(e1 -> {
                index = buddyList.getSelectedIndex();
            });
            this.add(new JScrollPane(buddyList));

        }
        else if (e.getActionCommand() == "item2") {
            String name = JOptionPane.showInputDialog("Please Enter Name");
            String address = JOptionPane.showInputDialog("Please Enter Address");
            String phoneNumber = JOptionPane.showInputDialog("Please Enter Phone Number");
            BuddyInfo bud = new BuddyInfo(name, address, phoneNumber);
            this.addBuddy(bud);
            this.insertList();
            this.updateList();
        }

        else if (e.getActionCommand() == "item21") {
            this.removeBuddy(index);
            index = Integer.parseInt(null);
        }

//        else if (e.getActionCommand() == "item3") {
//
//            buddyList = new JList(myBuddies.toArray());
//
//            buddyList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//            buddyList.addListSelectionListener(e1 -> {
//                index = buddyList.getSelectedIndex();
//            });
//            this.add(new JScrollPane(buddyList));

//            MouseListener mouseListener = new MouseAdapter() {
//                @Override
//                public void mouseClicked(MouseEvent e) {
//                    index = buddyList.locationToIndex(e.getPoint());
//                }
//            };
//            buddyList.addMouseListener(mouseListener);

//        }
    }

    public static void main(String[] args) {
//        BuddyInfo buddy = new BuddyInfo("Tom", "Carleton", "613");
//        AddressBook addressBook = new AddressBook();
//        addressBook.addBuddy(buddy);
//        addressBook.removeBuddy(0);
        new AddressBook();
    }
}
