import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddressBook extends JFrame implements ActionListener{

    private JList<String> buddyList;
    private DefaultListModel<BuddyInfo> myBuddies;
    private int index;
    private static AddressBook ab;

    public AddressBook() {
        super("Address Book");
        this.setLayout(new BorderLayout());

        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
        item1.setActionCommand("item1");
        item1.addActionListener(this);
        fileMenu.add(item1);

        item2 = new JMenuItem("Add Buddy");
        item2.setActionCommand("item2");
        item2.addActionListener(this);
        editMenu.add(item2);

        item21 = new JMenuItem("Remove Buddy");
        item21.setActionCommand("item21");
        item21.addActionListener(this);
        editMenu.add(item21);

        buddyList = new JList(myBuddies);
        buddyList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        buddyList.addListSelectionListener(e1 -> {
            index = buddyList.getSelectedIndex();
        });
        this.add(new JScrollPane(buddyList));
        this.add(buddyList);

        this.setVisible(true);

    }

    public void addBuddy(BuddyInfo aBuddy) {
        if (aBuddy != null && checkBuddy(aBuddy)) {
            myBuddies.addElement(aBuddy);
        } else {
            JOptionPane.showMessageDialog(this, "This Buddy already Exists!");
        }
    }

    public boolean checkBuddy(BuddyInfo aBuddy) {
        for (int i = 0; i < myBuddies.getSize(); i++) {
            String modelTemp = myBuddies.elementAt(i).toString();
            String aBuddyTemp = aBuddy.toString();
            if (modelTemp.equals(aBuddyTemp)) {
                return false;
            } else {
                return true;
            }
        }
        return true;
    }

    public void removeBuddy(int index) {
        if (index != -1 ) {
            myBuddies.remove(index);
        } else if (myBuddies.getSize() == 0) {
            JOptionPane.showMessageDialog(this, "You have no Buddy to remove!");
        } else {
            JOptionPane.showMessageDialog(this, "Select a Buddy to remove.");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "item1") {
            ab.dispose();
            ab = new AddressBook();

        } else if (e.getActionCommand() == "item2") {
            String name = JOptionPane.showInputDialog("Please Enter Name");
            String address = JOptionPane.showInputDialog("Please Enter Address");
            String phoneNumber = JOptionPane.showInputDialog("Please Enter Phone Number");
            BuddyInfo bud = new BuddyInfo(name, address, phoneNumber);
            this.addBuddy(bud);
        } else if (e.getActionCommand() == "item21") {
            this.removeBuddy(index);
        }
    }

    public static void main(String[] args) {
        ab = new AddressBook();
    }
}
