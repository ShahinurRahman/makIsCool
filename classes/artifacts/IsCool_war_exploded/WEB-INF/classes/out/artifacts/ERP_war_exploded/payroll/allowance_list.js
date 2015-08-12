/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 7/18/12
 * Time: 11:19 PM
 * To change this template use File | Settings | File Templates.
 */

var allowanceDataStore;
var checkBoxSelMod;
var allowanceListingEditorGrid;
var confirmationMessage;

var checkBoxSelModForGroupAssignment;
var groupListingEditorGridForAssignment;
var allowanceGroupStore;



Ext.onReady(function(){

    allowanceDataStore = new Ext.data.Store({
        id: "allowanceDataStore",
        url: 'userJsonData.cool',
        reader: new Ext.data.JsonReader({
            root: 'userList',
            totalProperty: 'totalCount',
            id: 'id'
        },[
            {name: 'id', type: 'int', mapping: 'id'},
            {name: 'username', type: 'string', mapping: 'username'},
            {name: 'password', type: 'string', mapping: 'password'},
            {name: 'active', type: 'boolean', mapping: 'active'}
        ]),
        autoLoad : true
    })

    checkBoxSelMod = new Ext.grid.CheckboxSelectionModel();
    allowanceListingEditorGrid = new Ext.grid.EditorGridPanel({
        id: "authorityListingEditorGrid",
        store : allowanceDataStore,
        selModel : checkBoxSelMod,
        clicksToEdit: 2,
        renderTo: "list_employee",
        width: 560,
        height: 300,
        columns : [
            {
                dataIndex: 'id',
                header: 'ID',
                width: 80,
                sortable: true
            },{
                dataIndex: 'username',
                header: 'User Name',
                sortable: true,
                width:200,
                editable: false
            },{
                dataIndex: 'password',
                header: 'Password',
                sortable: true,
                width: 75
            },{
                dataIndex: 'active',
                header: 'Active Status',
                sortable: true,
                width: 75
            }
        ],
        stripeRows : true,
        bbar: new Ext.PagingToolbar({
            store : allowanceDataStore,
            pageSize : 15,
            displayInfo : true,
            displaymsg : 'Displaying {0} - {1} of {2}',
            emptyMsg : "No records found"
        }),
        tbar: [{
            xtype: "button",
            text: "Add User",
            iconCls: "addRecord",
            handler:function(){
                window.location="createUser.cool"
            }
        },{
            xtype: "button",
            text: "Group Assignment",
            iconCls: "assignment",
            handler:function(){
                window.location="createUser.cool"
            }
        }]
    });
    allowanceDataStore.load({params: {start: 0, limit: 15}});

})

