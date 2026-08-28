# ArtefactDraft


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**draft_id** | **str** |  | [optional] 
**kind** | [**ArtefactKind**](ArtefactKind.md) |  | [optional] 
**yaml** | **str** |  | [optional] 
**valid** | **bool** |  | [optional] 
**constraints** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.artefact_draft import ArtefactDraft

# TODO update the JSON string below
json = "{}"
# create an instance of ArtefactDraft from a JSON string
artefact_draft_instance = ArtefactDraft.from_json(json)
# print the JSON string representation of the object
print(ArtefactDraft.to_json())

# convert the object into a dict
artefact_draft_dict = artefact_draft_instance.to_dict()
# create an instance of ArtefactDraft from a dict
artefact_draft_from_dict = ArtefactDraft.from_dict(artefact_draft_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


