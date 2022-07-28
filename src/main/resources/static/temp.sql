select ex.id as id, department as department, plant as plant, block as block, technological_place as technologicalPlace, clacification as clacification ,
       equipment_nidentification as equipmentnIdentification, serial_nomer as serialNomer,registration_nomer as registrationNomer,
       equipment_type as equipmentType, f.id as factoryId, f.factory_name as factoryName
from exchanger  as ex  inner join factory as f on f.id = ex.factory_id
UNION ALL
select ex.id as id, department as department, plant as plant, block as block, technological_place as technologicalPlace, clacification as clacification ,
       equipment_nidentification as equipmentnIdentification, serial_nomer as serialNomer,registration_nomer as registrationNomer,
       equipment_type as equipmentType, f.id as factoryId, f.factory_name as factoryName
from separator  as ex  inner join factory as f on f.id = ex.factory_id
UNION ALL
select ex.id as id, department as department, plant as plant, block as block, technological_place as technologicalPlace, clacification as clacification ,
       equipment_nidentification as equipmentnIdentification, serial_nomer as serialNomer,registration_nomer as registrationNomer,
       equipment_type as equipmentType, f.id as factoryId, f.factory_name as factoryName
from air_compressor  as ex  inner join factory as f on f.id = ex.factory_id
UNION ALL
select ex.id as id, department as department, plant as plant, block as block, technological_place as technologicalPlace, clacification as clacification ,
       equipment_nidentification as equipmentnIdentification, serial_nomer as serialNomer,registration_nomer as registrationNomer,
       equipment_type as equipmentType, f.id as factoryId, f.factory_name as factoryName
from avo  as ex  inner join factory as f on f.id = ex.factory_id
UNION ALL
select ex.id as id, department as department, plant as plant, block as block, technological_place as technologicalPlace, clacification as clacification ,
       equipment_nidentification as equipmentnIdentification, serial_nomer as serialNomer,registration_nomer as registrationNomer,
       equipment_type as equipmentType, f.id as factoryId, f.factory_name as factoryName
from boiler  as ex  inner join factory as f on f.id = ex.factory_id
UNION ALL
select ex.id as id, department as department, plant as plant, block as block, technological_place as technologicalPlace, clacification as clacification ,
       equipment_nidentification as equipmentnIdentification, serial_nomer as serialNomer,registration_nomer as registrationNomer,
       equipment_type as equipmentType, f.id as factoryId, f.factory_name as factoryName
from compressor  as ex  inner join factory as f on f.id = ex.factory_id
UNION ALL
select ex.id as id, department as department, plant as plant, block as block, technological_place as technologicalPlace, clacification as clacification ,
       equipment_nidentification as equipmentnIdentification, serial_nomer as serialNomer,registration_nomer as registrationNomer,
       equipment_type as equipmentType, f.id as factoryId, f.factory_name as factoryName
from gpa  as ex  inner join factory as f on f.id = ex.factory_id
UNION ALL
select ex.id as id, department as department, plant as plant, block as block, technological_place as technologicalPlace, clacification as clacification ,
       equipment_nidentification as equipmentnIdentification, serial_nomer as serialNomer,registration_nomer as registrationNomer,
       equipment_type as equipmentType, f.id as factoryId, f.factory_name as factoryName
from pipeline  as ex  inner join factory as f on f.id = ex.factory_id
UNION ALL
select ex.id as id, department as department, plant as plant, block as block, technological_place as technologicalPlace, clacification as clacification ,
       equipment_nidentification as equipmentnIdentification, serial_nomer as serialNomer,registration_nomer as registrationNomer,
       equipment_type as equipmentType, f.id as factoryId, f.factory_name as factoryName
from pump  as ex  inner join factory as f on f.id = ex.factory_id
UNION ALL
select ex.id as id, department as department, plant as plant, block as block, technological_place as technologicalPlace, clacification as clacification ,
       equipment_nidentification as equipmentnIdentification, serial_nomer as serialNomer,registration_nomer as registrationNomer,
       equipment_type as equipmentType, f.id as factoryId, f.factory_name as factoryName
from reservoir  as ex  inner join factory as f on f.id = ex.factory_id
UNION ALL
select ex.id as id, department as department, plant as plant, block as block, technological_place as technologicalPlace, clacification as clacification ,
       equipment_nidentification as equipmentnIdentification, serial_nomer as serialNomer,registration_nomer as registrationNomer,
       equipment_type as equipmentType, f.id as factoryId, f.factory_name as factoryName
from torch  as ex  inner join factory as f on f.id = ex.factory_id
UNION ALL
select ex.id as id, department as department, plant as plant, block as block, technological_place as technologicalPlace, clacification as clacification ,
       equipment_nidentification as equipmentnIdentification, serial_nomer as serialNomer,registration_nomer as registrationNomer,
       equipment_type as equipmentType, f.id as factoryId, f.factory_name as factoryName
from columnss  as ex  inner join factory as f on f.id = ex.factory_id