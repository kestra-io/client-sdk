"""Pure model decode tests — no live Kestra server required."""

from kestrapy.models.type import Type
from kestrapy.models.input_object import InputObject
from kestrapy.models.flow import Flow


def test_type_form_value_exists():
    assert Type("FORM") == Type.FORM


def test_input_object_decodes_form_type():
    obj = InputObject.from_dict({"id": "myform", "type": "FORM"})
    assert obj.type == Type.FORM


def test_flow_decodes_input_with_form_type():
    flow = Flow.from_dict({
        "id": "f",
        "namespace": "ns",
        "disabled": False,
        "deleted": False,
        "tasks": [{"id": "t", "type": "io.kestra.plugin.core.log.Log"}],
        "inputs": [{"id": "myform", "type": "FORM"}],
    })
    assert flow.inputs[0].type == Type.FORM
