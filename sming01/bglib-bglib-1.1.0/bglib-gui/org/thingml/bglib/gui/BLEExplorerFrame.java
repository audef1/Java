/**
 * Copyright (C) 2012 SINTEF <franck.fleurey@sintef.no>
 *
 * Licensed under the GNU LESSER GENERAL PUBLIC LICENSE, Version 3, 29 June 2007;
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.gnu.org/licenses/lgpl-3.0.txt
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.thingml.bglib.gui;

import gnu.io.SerialPort;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.thingml.bglib.BDAddr;
import org.thingml.bglib.BGAPITransport;
import org.thingml.bglib.BGAPI;
import org.thingml.bglib.BGAPIListener;
import org.thingml.bglib.BGAPIPacketLogger;

/**
 *
 * @author franck
 */
public class BLEExplorerFrame extends javax.swing.JFrame implements BGAPIListener {

    protected BGAPI bgapi;
    protected SerialPort port;
    
    protected BLEDeviceList devList = new BLEDeviceList();
    
    /**
     * Creates new form BLEExplorerFrame
     */
    public BLEExplorerFrame() {
        initComponents();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        
        BLED112.initRXTX();
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BLEExplorerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BLEExplorerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BLEExplorerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BLEExplorerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BLEExplorerFrame().setVisible(true);
            }
        });
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButtonBLED112Disc = new javax.swing.JButton();
        jButtonBLED112Conn = new javax.swing.JButton();
        jTextFieldBLED112 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListDevices = new javax.swing.JList();
        jButtonStopDiscover = new javax.swing.JButton();
        jButtonDiscover = new javax.swing.JButton();
        jButtonDisconnect = new javax.swing.JButton();
        jButtonConnect = new javax.swing.JButton();
        jTextFieldConnStatus = new javax.swing.JTextField();
        jButtonRefresh = new javax.swing.JButton();
        jCheckBoxDebug = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        jButtonDiscovery = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButtonAttributes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("BLED112:");

        jButtonBLED112Disc.setText("Disconnect");
        jButtonBLED112Disc.setEnabled(false);
        jButtonBLED112Disc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBLED112DiscActionPerformed(evt);
            }
        });

        jButtonBLED112Conn.setText("Connect");
        jButtonBLED112Conn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBLED112ConnActionPerformed(evt);
            }
        });

        jTextFieldBLED112.setText("Not Connected.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldBLED112)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonBLED112Conn, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonBLED112Disc, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1)
                .addComponent(jButtonBLED112Disc)
                .addComponent(jButtonBLED112Conn)
                .addComponent(jTextFieldBLED112, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel2.setText("BLE Devices:");

        jListDevices.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jListDevices);

        jButtonStopDiscover.setText("Stop");
        jButtonStopDiscover.setEnabled(false);
        jButtonStopDiscover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStopDiscoverActionPerformed(evt);
            }
        });

        jButtonDiscover.setText("Discover");
        jButtonDiscover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDiscoverActionPerformed(evt);
            }
        });

        jButtonDisconnect.setText("Disconnect");
        jButtonDisconnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDisconnectActionPerformed(evt);
            }
        });

        jButtonConnect.setText("Connect");
        jButtonConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConnectActionPerformed(evt);
            }
        });

        jTextFieldConnStatus.setText("No connection.");

        jButtonRefresh.setText("Refresh");
        jButtonRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRefreshActionPerformed(evt);
            }
        });

        jCheckBoxDebug.setText("Debug BLED112");
        jCheckBoxDebug.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxDebugActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckBoxDebug))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButtonRefresh)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldConnStatus)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonDiscover, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                            .addComponent(jButtonConnect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonStopDiscover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonDisconnect, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jCheckBoxDebug))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonStopDiscover)
                        .addComponent(jButtonDiscover))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldConnStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonConnect)
                            .addComponent(jButtonDisconnect)
                            .addComponent(jButtonRefresh))))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jButtonDiscovery.setText("Discovery");
        jButtonDiscovery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDiscoveryActionPerformed(evt);
            }
        });

        jButton1.setText("Subscribe All");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButtonAttributes.setText("Attributes");
        jButtonAttributes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAttributesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonAttributes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonDiscovery, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonDiscovery)
                    .addComponent(jButton1)
                    .addComponent(jButtonAttributes))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBLED112ConnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBLED112ConnActionPerformed
        jButtonBLED112Conn.setEnabled(false);
        jButtonBLED112Disc.setEnabled(false);
        port  = BLED112.connectSerial(BLED112.selectSerialPort());
        if (port != null) {
            try {
                jTextFieldBLED112.setText("Connected on " + port);
                bgapi = new BGAPI(new BGAPITransport(port.getInputStream(), port.getOutputStream()));
                bgapi.addListener(this);
                Thread.sleep(250);
                bgapi.send_system_get_info();
                jButtonBLED112Disc.setEnabled(true);
                if (jCheckBoxDebug.isSelected()) bgapi.getLowLevelDriver().addListener(logger);
                
            } catch (Exception ex) {
                Logger.getLogger(BLEExplorerFrame.class.getName()).log(Level.SEVERE, null, ex);
                jTextFieldBLED112.setText("Exception while connecting to " + port);
                jButtonBLED112Conn.setEnabled(true);
            }
        }
        else {
            jTextFieldBLED112.setText("Not Connected.");
            jButtonBLED112Conn.setEnabled(true);
        }
    }//GEN-LAST:event_jButtonBLED112ConnActionPerformed

    private void jButtonBLED112DiscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBLED112DiscActionPerformed
        jButtonBLED112Conn.setEnabled(false);
        jButtonBLED112Disc.setEnabled(false);
        //jCheckBoxDebug.setSelected(false);
        
        if (bgapi != null) {
            bgapi.removeListener(this);
            bgapi.getLowLevelDriver().removeListener(logger);
            bgapi.send_system_reset(0);
            bgapi.disconnect();
        }
        if (port != null) {
            port.close();
        }
        bgapi = null;
        port = null;
        jTextFieldBLED112.setText("Disconnected.");
        jButtonBLED112Conn.setEnabled(true);
    }//GEN-LAST:event_jButtonBLED112DiscActionPerformed

    private void jButtonDiscoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDiscoverActionPerformed
        devList.clear();
        jListDevices.setModel(devList);
        bgapi.send_gap_set_scan_parameters(10, 250, 1);
        bgapi.send_gap_discover(1);
        jButtonDiscover.setEnabled(false);
        jButtonStopDiscover.setEnabled(true);
    }//GEN-LAST:event_jButtonDiscoverActionPerformed

    private void jButtonConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConnectActionPerformed
        
        BLEDevice d = (BLEDevice) jListDevices.getSelectedValue();
        if (d == null) return;
        
        jButtonConnect.setEnabled(false);
        jButtonDisconnect.setEnabled(true);
        
        bgapi.send_gap_connect_direct(BDAddr.fromString(d.getAddress()), 1, 0x3C, 0x3C, 0x64,0);
    }//GEN-LAST:event_jButtonConnectActionPerformed

    private void jButtonStopDiscoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStopDiscoverActionPerformed
        bgapi.send_gap_end_procedure();
        jButtonStopDiscover.setEnabled(false);
        jButtonDiscover.setEnabled(true);
        
    }//GEN-LAST:event_jButtonStopDiscoverActionPerformed

    private void jButtonDisconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDisconnectActionPerformed
        bledevice = null;
        if (connection >= 0) {
            bgapi.send_connection_disconnect(connection);
        }
        jTextFieldConnStatus.setText("Diconnected.");
        jButtonConnect.setEnabled(true);
        jButtonDisconnect.setEnabled(false);

    }//GEN-LAST:event_jButtonDisconnectActionPerformed

    private void jButtonRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRefreshActionPerformed
        if (connection < 0) {
            
            jTextFieldConnStatus.setText("Not Connected.");
        }
        else {
            bgapi.send_connection_get_status(connection);
        }
    }//GEN-LAST:event_jButtonRefreshActionPerformed

    private void jButtonDiscoveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDiscoveryActionPerformed
        discovery_state = SERVICES;
        bgapi.send_attclient_read_by_group_type(connection, 0x0001, 0xFFFF, new byte[]{0x00, 0x28} );
    }//GEN-LAST:event_jButtonDiscoveryActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //bgapi.send_attclient_attribute_write(connection, 0x24, new byte[]{0x0B, 0x10} );
        //bgapi.send_attclient_attribute_write(connection, 0x20, new byte[]{0x03});
        //bgapi.send_attributes_read(0x24, 0);
        bgapi.send_attclient_read_by_handle(connection, 0x24);
    }//GEN-LAST:event_jButton1ActionPerformed

    private BGAPIPacketLogger logger = new BGAPIPacketLogger();
    
    private void jCheckBoxDebugActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxDebugActionPerformed
        
        if (bgapi == null) return;
        if (jCheckBoxDebug.isSelected()) {
            bgapi.getLowLevelDriver().addListener(logger);
        }
        else {
            bgapi.getLowLevelDriver().removeListener(logger);
        }
    }//GEN-LAST:event_jCheckBoxDebugActionPerformed

    private void jButtonAttributesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAttributesActionPerformed
        new AttributeFrame(bgapi, connection).setVisible(true);
    }//GEN-LAST:event_jButtonAttributesActionPerformed
    
    /*
     * GATT DISCOVERY
     */
    private static final int IDLE = 0;
    private static final int SERVICES = 1;
    private static final int ATTRIBUTES = 2;
    private Iterator<BLEService> discovery_it = null;
    private BLEService discovery_srv = null;
    private int discovery_state = IDLE;
    
    // Callbacks for class system (index = 0)
	public void receive_system_reset() {}
	public void receive_system_hello() {}
	public void receive_system_address_get(BDAddr address) {}
	public void receive_system_reg_write(int result) {}
	public void receive_system_reg_read(int address, int value) {}
	public void receive_system_get_counters(int txok, int txretry, int rxok, int rxfail) {}
	public void receive_system_get_connections(int maxconn) {}
	public void receive_system_read_memory(int address, byte[] data) {}
	public void receive_system_get_info(int major, int minor, int patch, int build, int ll_version, int protocol_version, int hw) {
            jTextFieldBLED112.setText("Connected. BLED112:" + major + "." + minor + "." + patch + " (" + build + ") " + "ll=" + ll_version + " hw=" + hw);
        }
	public void receive_system_endpoint_tx() {}
	public void receive_system_whitelist_append(int result) {}
	public void receive_system_whitelist_remove(int result) {}
	public void receive_system_whitelist_clear() {}
	public void receive_system_boot(int major, int minor, int patch, int build, int ll_version, int protocol_version, int hw) {}
	public void receive_system_debug(byte[] data) {}
	public void receive_system_endpoint_rx(int endpoint, byte[] data) {}

	// Callbacks for class flash (index = 1)
	public void receive_flash_ps_defrag() {}
	public void receive_flash_ps_dump() {}
	public void receive_flash_ps_erase_all() {}
	public void receive_flash_ps_save(int result) {}
	public void receive_flash_ps_load(int result, byte[] value) {}
	public void receive_flash_ps_erase() {}
	public void receive_flash_erase_page(int result) {}
	public void receive_flash_write_words() {}
	public void receive_flash_ps_key(int key, byte[] value) {}

	// Callbacks for class attributes (index = 2)
	public void receive_attributes_write(int result) {}
	public void receive_attributes_read(int handle, int offset, int result, byte[] value) {}
	public void receive_attributes_read_type(int handle, int result, byte[] value) {}
	public void receive_attributes_user_response() {}
	public void receive_attributes_value(int connection, int reason, int handle, int offset, byte[] value) {
            System.out.println("Attribute Value att=" + Integer.toHexString(handle) + " val = " + bytesToString(value));
        }
	public void receive_attributes_user_request(int connection, int handle, int offset) {}

	// Callbacks for class connection (index = 3)
	public void receive_connection_disconnect(int connection, int result) {}
	public void receive_connection_get_rssi(int connection, int rssi) {}
	public void receive_connection_update(int connection, int result) {}
	public void receive_connection_version_update(int connection, int result) {}
	public void receive_connection_channel_map_get(int connection, byte[] map) {}
	public void receive_connection_channel_map_set(int connection, int result) {}
	public void receive_connection_features_get(int connection, int result) {}
	public void receive_connection_get_status(int connection) {}
	public void receive_connection_raw_tx(int connection) {}
	
        protected int connection = -1;
        protected BLEDevice bledevice = null;
        public void receive_connection_status(int conn, int flags, BDAddr address, int address_type, int conn_interval, int timeout, int latency, int bonding) {
            jTextFieldConnStatus.setText("[" + address.toString() + "] Conn = " + conn + " Flags = " + flags);
            if (flags != 0) {
                bledevice = devList.getFromAddress(address.toString());
                this.connection = conn;
                jButtonConnect.setEnabled(false);
                jButtonDisconnect.setEnabled(true);
            }
            else {
                System.out.println("Connection lost!");
                connection = -1;
                bledevice = null;
                jButtonConnect.setEnabled(true);
                jButtonDisconnect.setEnabled(false);
            } 
        }
	public void receive_connection_version_ind(int connection, int vers_nr, int comp_id, int sub_vers_nr) {}
	public void receive_connection_feature_ind(int connection, byte[] features) {}
	public void receive_connection_raw_rx(int connection, byte[] data) {}
	public void receive_connection_disconnected(int connection, int reason) {}

	// Callbacks for class attclient (index = 4)
	public void receive_attclient_find_by_type_value(int connection, int result) {}
	public void receive_attclient_read_by_group_type(int connection, int result) {}
	public void receive_attclient_read_by_type(int connection, int result) {}
	public void receive_attclient_find_information(int connection, int result) {}
	public void receive_attclient_read_by_handle(int connection, int result) {}
	public void receive_attclient_attribute_write(int connection, int result) {}
	public void receive_attclient_write_command(int connection, int result) {}
	public void receive_attclient_reserved() {}
	public void receive_attclient_read_long(int connection, int result) {}
	public void receive_attclient_prepare_write(int connection, int result) {}
	public void receive_attclient_execute_write(int connection, int result) {}
	public void receive_attclient_read_multiple(int connection, int result) {}
	public void receive_attclient_indicated(int connection, int attrhandle) {}
	public void receive_attclient_procedure_completed(int connection, int result, int chrhandle) {
            if (discovery_state != IDLE && bledevice != null) {
                if (discovery_state == SERVICES) { // services have been discovered
                    discovery_it = bledevice.getServices().values().iterator();
                    discovery_state = ATTRIBUTES;
                }
                if (discovery_state == ATTRIBUTES) {
                    if (discovery_it.hasNext()) {
                        discovery_srv = discovery_it.next();
                        bgapi.send_attclient_find_information(connection, discovery_srv.getStart(), discovery_srv.getEnd());
                    }
                    else { // Discovery is done
                        System.out.println("Discovery completed:");
                        System.out.println(bledevice.getGATTDescription());
                        discovery_state = IDLE;
                    }
                }
            }
            if (result != 0) {
                System.err.println("ERROR: Attribute Procedure Completed with error code 0x" + Integer.toHexString(result));
            }
        }
	public void receive_attclient_group_found(int connection, int start, int end, byte[] uuid) {
            if (bledevice != null) {
                BLEService srv = new BLEService(uuid, start, end);
                bledevice.getServices().put(srv.getUuidString(), srv); 
            }
        }
	public void receive_attclient_attribute_found(int connection, int chrdecl, int value, int properties, byte[] uuid) {}
	public void receive_attclient_find_information_found(int connection, int chrhandle, byte[] uuid) {
            if (discovery_state == ATTRIBUTES && discovery_srv != null) {
                BLEAttribute att = new BLEAttribute(uuid, chrhandle);
                discovery_srv.getAttributes().add(att);
            }
        }
	public void receive_attclient_attribute_value(int connection, int atthandle, int type, byte[] value) {
            System.out.println("Attclient Value att=" + Integer.toHexString(atthandle) + " val = " + bytesToString(value));
        }
	public void receive_attclient_read_multiple_response(int connection, byte[] handles) {}

	// Callbacks for class sm (index = 5)
	public void receive_sm_encrypt_start(int handle, int result) {}
	public void receive_sm_set_bondable_mode() {}
	public void receive_sm_delete_bonding(int result) {}
	public void receive_sm_set_parameters() {}
	public void receive_sm_passkey_entry(int result) {}
	public void receive_sm_get_bonds(int bonds) {}
	public void receive_sm_set_oob_data() {}
	public void receive_sm_smp_data(int handle, int packet, byte[] data) {}
	public void receive_sm_bonding_fail(int handle, int result) {}
	public void receive_sm_passkey_display(int handle, int passkey) {}
	public void receive_sm_passkey_request(int handle) {}
	public void receive_sm_bond_status(int bond, int keysize, int mitm, int keys) {}

	// Callbacks for class gap (index = 6)
	public void receive_gap_set_privacy_flags() {}
	public void receive_gap_set_mode(int result) {}
	public void receive_gap_discover(int result) {}
	public void receive_gap_connect_direct(int result, int connection_handle) {}
	public void receive_gap_end_procedure(int result) {}
	public void receive_gap_connect_selective(int result, int connection_handle) {}
	public void receive_gap_set_filtering(int result) {}
	public void receive_gap_set_scan_parameters(int result) {}
	public void receive_gap_set_adv_parameters(int result) {}
	public void receive_gap_set_adv_data(int result) {}
	public void receive_gap_set_directed_connectable_mode(int result) {}
	public void receive_gap_scan_response(int rssi, int packet_type, BDAddr sender, int address_type, int bond, byte[] data) {
            BLEDevice d = devList.getFromAddress(sender.toString());
            if (d == null) { 
                d = new BLEDevice(sender.toString());
                devList.add(d);
                System.out.println("Create device: " + d.toString());
            }
            String name = new String(data).trim();
            if (d.getName().length() < name.length()) d.setName(name);
            d.setRssi(rssi);
            devList.changed(d);
        }
	public void receive_gap_mode_changed(int discover, int connect) {}

	// Callbacks for class hardware (index = 7)
	public void receive_hardware_io_port_config_irq(int result) {}
	public void receive_hardware_set_soft_timer(int result) {}
	public void receive_hardware_adc_read(int result) {}
	public void receive_hardware_io_port_config_direction(int result) {}
	public void receive_hardware_io_port_config_function(int result) {}
	public void receive_hardware_io_port_config_pull(int result) {}
	public void receive_hardware_io_port_write(int result) {}
	public void receive_hardware_io_port_read(int result, int port, int data) {}
	public void receive_hardware_spi_config(int result) {}
	public void receive_hardware_spi_transfer(int result, int channel, byte[] data) {}
	public void receive_hardware_i2c_read(int result, byte[] data) {}
	public void receive_hardware_i2c_write(int written) {}
	public void receive_hardware_set_txpower() {}
	public void receive_hardware_io_port_status(int timestamp, int port, int irq, int state) {}
	public void receive_hardware_soft_timer(int handle) {}
	public void receive_hardware_adc_result(int input, int value) {}

	// Callbacks for class test (index = 8)
	public void receive_test_phy_tx() {}
	public void receive_test_phy_rx() {}
	public void receive_test_phy_end(int counter) {}
	public void receive_test_phy_reset() {}
	public void receive_test_get_channel_map(byte[] channel_map) {}
        
        
   public String bytesToString(byte[] bytes) {
        StringBuffer result = new StringBuffer();
        result.append("[ ");
        for(byte b : bytes) result.append( Integer.toHexString(b & 0xFF) + " ");
        result.append("]");
        return result.toString();        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAttributes;
    private javax.swing.JButton jButtonBLED112Conn;
    private javax.swing.JButton jButtonBLED112Disc;
    private javax.swing.JButton jButtonConnect;
    private javax.swing.JButton jButtonDisconnect;
    private javax.swing.JButton jButtonDiscover;
    private javax.swing.JButton jButtonDiscovery;
    private javax.swing.JButton jButtonRefresh;
    private javax.swing.JButton jButtonStopDiscover;
    private javax.swing.JCheckBox jCheckBoxDebug;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList jListDevices;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldBLED112;
    private javax.swing.JTextField jTextFieldConnStatus;
    // End of variables declaration//GEN-END:variables
}
