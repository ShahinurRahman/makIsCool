/**
 * Created by IntelliJ IDEA.
 * User: ronnie
 * Date: 7/4/12
 * Time: 1:13 AM
 * To change this template use File | Settings | File Templates.
 */

var checkBoxSelMod;
var employeeListingEditorGrid;
var editEmployeeFeature = "editEmploymentStatus";
var deleteEmployeeFeature = "deleteEmploymentStatus";
var confirmationMessage;

var checkBoxSelModForGroupAssignment;
var groupListingEditorGridForAssignment;
var employeeStatusDataStore;



Ext.onReady(function(){

    employeeStatusDataStore = new Ext.data.Store({
        id: "authorityDataStore",
        url: 'employmentStatusJsonData.cool',
        reader: new Ext.data.JsonReader({
            root: 'employmentStatusList',
            totalProperty: 'totalCount',
            id: 'id'
        },[
            {name: 'id',                    type: 'int',        mapping: 'id'},
            {name: 'statusCode',            type: 'string',     mapping: 'statusCode'},
            {name: 'statusName',            type: 'string',     mapping: 'statusName'},
            {name: 'statusDescription',     type: 'string',     mapping: 'statusDescription'}
        ]),
        autoLoad : true
    })

    checkBoxSelMod = new Ext.grid.CheckboxSelectionModel();
    employeeListingEditorGrid = new Ext.grid.EditorGridPanel({
        id: "employmentStatusEditorGrid",
        store : employeeStatusDataStore,
        selModel : checkBoxSelMod,
        clicksToEdit: 2,
        renderTo: "list_employment_status",
        width: 560,
        height: 300,
        columns : [
            {
                dataIndex: 'id',
                header: 'Identifier',
                width: 80,
                sortable: true
            },{
                dataIndex: 'statusCode',
                header: 'Status Code',
                sortable: true,
                width: 70
            },{
                dataIndex: 'statusName',
                header: 'Status Name',
                sortable: true,
                width: 70
            },{
                dataIndex: 'statusDescription',
                header: 'Status Description',
                sortable: true,
                width: 70
            }
        ],
        stripeRows : true,
        bbar: new Ext.PagingToolbar({
            store : employeeStatusDataStore,
            pageSize : 15,
            displayInfo : true,
            displaymsg : 'Displaying {0} - {1} of {2}',
            emptyMsg : "No records found"
        }),
        tbar: [{
            xtype: "button",
            text: "Add EmpCsd Status",
            iconCls: "addRecord",
            handler:function(){
                window.location="createEmploymentStatus.cool"
            }
        }]
    });
    employeeStatusDataStore.load({params: {start: 0, limit: 15}});

})

