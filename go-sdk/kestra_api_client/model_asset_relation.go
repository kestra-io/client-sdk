package kestra_api_client

import "time"

// Enums here skip a strict UnmarshalJSON so a value added server-side does not fail the whole decode.

type RelationKind string

const (
	RELATIONKIND_PRODUCES    RelationKind = "PRODUCES"
	RELATIONKIND_CONSUMED_BY RelationKind = "CONSUMED_BY"
	RELATIONKIND_UPSTREAM_OF RelationKind = "UPSTREAM_OF"
	RELATIONKIND_PART_OF     RelationKind = "PART_OF"
	RELATIONKIND_RELATED     RelationKind = "RELATED"
	RELATIONKIND_WRITES      RelationKind = "WRITES"
	RELATIONKIND_READS       RelationKind = "READS"
	RELATIONKIND_UNKNOWN     RelationKind = "UNKNOWN"
)

var AllowedRelationKindEnumValues = []RelationKind{
	RELATIONKIND_PRODUCES, RELATIONKIND_CONSUMED_BY, RELATIONKIND_UPSTREAM_OF, RELATIONKIND_PART_OF,
	RELATIONKIND_RELATED, RELATIONKIND_WRITES, RELATIONKIND_READS, RELATIONKIND_UNKNOWN,
}

func (v RelationKind) IsValid() bool { return containsEnum(AllowedRelationKindEnumValues, v) }

func (v RelationKind) Ptr() *RelationKind { return &v }

type RelationDirection string

const (
	RELATIONDIRECTION_OUTBOUND RelationDirection = "OUTBOUND"
	RELATIONDIRECTION_INBOUND  RelationDirection = "INBOUND"
	RELATIONDIRECTION_BOTH     RelationDirection = "BOTH"
)

var AllowedRelationDirectionEnumValues = []RelationDirection{
	RELATIONDIRECTION_OUTBOUND, RELATIONDIRECTION_INBOUND, RELATIONDIRECTION_BOTH,
}

func (v RelationDirection) IsValid() bool {
	return containsEnum(AllowedRelationDirectionEnumValues, v)
}

func (v RelationDirection) Ptr() *RelationDirection { return &v }

type RelationOrigin string

const (
	RELATIONORIGIN_DERIVED  RelationOrigin = "DERIVED"
	RELATIONORIGIN_DECLARED RelationOrigin = "DECLARED"
	RELATIONORIGIN_MANUAL   RelationOrigin = "MANUAL"
)

var AllowedRelationOriginEnumValues = []RelationOrigin{
	RELATIONORIGIN_DERIVED, RELATIONORIGIN_DECLARED, RELATIONORIGIN_MANUAL,
}

func (v RelationOrigin) IsValid() bool { return containsEnum(AllowedRelationOriginEnumValues, v) }

func (v RelationOrigin) Ptr() *RelationOrigin { return &v }

type RelationState string

const (
	RELATIONSTATE_ACTIVE  RelationState = "ACTIVE"
	RELATIONSTATE_REMOVED RelationState = "REMOVED"
)

var AllowedRelationStateEnumValues = []RelationState{RELATIONSTATE_ACTIVE, RELATIONSTATE_REMOVED}

func (v RelationState) IsValid() bool { return containsEnum(AllowedRelationStateEnumValues, v) }

func (v RelationState) Ptr() *RelationState { return &v }

type NodeType string

const (
	NODETYPE_ASSET    NodeType = "ASSET"
	NODETYPE_FLOW     NodeType = "FLOW"
	NODETYPE_TASK_RUN NodeType = "TASK_RUN"
)

var AllowedNodeTypeEnumValues = []NodeType{NODETYPE_ASSET, NODETYPE_FLOW, NODETYPE_TASK_RUN}

func (v NodeType) IsValid() bool { return containsEnum(AllowedNodeTypeEnumValues, v) }

func (v NodeType) Ptr() *NodeType { return &v }

func containsEnum[T comparable](values []T, v T) bool {
	for _, existing := range values {
		if existing == v {
			return true
		}
	}
	return false
}

// ---- request types ----

type AssetRelationRef struct {
	Id        string  `json:"id"`
	Namespace *string `json:"namespace,omitempty"`
	Role      *string `json:"role,omitempty"`
}

type AssetsControllerApiParentRequest struct {
	ParentId  string  `json:"parentId"`
	Namespace *string `json:"namespace,omitempty"`
	Role      *string `json:"role,omitempty"`
}

// TargetNamespace is required when the target is a flow; Direction is ignored by an undirected kind.
type AssetsControllerApiRelationRequest struct {
	Kind            RelationKind      `json:"kind"`
	Direction       RelationDirection `json:"direction"`
	TargetId        string            `json:"targetId"`
	TargetNamespace *string           `json:"targetNamespace,omitempty"`
	Role            *string           `json:"role,omitempty"`
}

// ---- response types ----

type AssetsControllerApiRelationNode struct {
	Uid       string   `json:"uid"`
	Namespace *string  `json:"namespace,omitempty"`
	Id        *string  `json:"id,omitempty"`
	Type      NodeType `json:"type,omitempty"`
	AssetType *string  `json:"assetType,omitempty"`
}

type RelationProvenance struct {
	Namespace    string     `json:"namespace,omitempty"`
	FlowId       string     `json:"flowId,omitempty"`
	FlowRevision *int32     `json:"flowRevision,omitempty"`
	ExecutionId  string     `json:"executionId,omitempty"`
	TaskId       string     `json:"taskId,omitempty"`
	TaskRunId    string     `json:"taskRunId,omitempty"`
	TaskType     *string    `json:"taskType,omitempty"`
	State        StateType  `json:"state,omitempty"`
	StartDate    *time.Time `json:"startDate,omitempty"`
	EndDate      *time.Time `json:"endDate,omitempty"`
}

type AssetsControllerApiRelation struct {
	Uid        string                          `json:"uid"`
	Kind       RelationKind                    `json:"kind,omitempty"`
	Role       *string                         `json:"role,omitempty"`
	Origin     RelationOrigin                  `json:"origin,omitempty"`
	State      RelationState                   `json:"state,omitempty"`
	Source     AssetsControllerApiRelationNode `json:"source"`
	Target     AssetsControllerApiRelationNode `json:"target"`
	Provenance *RelationProvenance             `json:"provenance,omitempty"`
	Created    *time.Time                      `json:"created,omitempty"`
	Updated    *time.Time                      `json:"updated,omitempty"`
}

type AssetsControllerApiRelationItem struct {
	Relation AssetsControllerApiRelation     `json:"relation"`
	Node     AssetsControllerApiRelationNode `json:"node"`
	Asset    *AssetsControllerApiAsset       `json:"asset,omitempty"`
}

type AssetsControllerApiRelationGroup struct {
	Kind       RelationKind                      `json:"kind"`
	Direction  RelationDirection                 `json:"direction"`
	Total      int64                             `json:"total"`
	Results    []AssetsControllerApiRelationItem `json:"results"`
	NextCursor *string                           `json:"nextCursor,omitempty"`
}

type AssetsControllerApiRelationSummary struct {
	Groups []AssetsControllerApiRelationGroup `json:"groups"`
}

// Pass NextCursor back as AssetRelations' `after` to get the next page.
type AssetsControllerApiRelationPage struct {
	Results    []AssetsControllerApiRelationItem `json:"results"`
	Total      int64                             `json:"total"`
	NextCursor *string                           `json:"nextCursor,omitempty"`
}

type AssetWriteSummary struct {
	ExecutionId string     `json:"executionId,omitempty"`
	Namespace   string     `json:"namespace,omitempty"`
	FlowId      string     `json:"flowId,omitempty"`
	TaskId      string     `json:"taskId,omitempty"`
	TaskType    string     `json:"taskType,omitempty"`
	State       StateType  `json:"state,omitempty"`
	Created     *time.Time `json:"created,omitempty"`
}

type AssetRelationGraph struct {
	Nodes     []AssetRelationGraphNode `json:"nodes"`
	Edges     []AssetRelationGraphEdge `json:"edges"`
	Truncated bool                     `json:"truncated"`
}

// A collapsed hub node's NextCursor is passed back as `hubCursor` to load more of its relations.
type AssetRelationGraphNode struct {
	Uid         string              `json:"uid"`
	Namespace   *string             `json:"namespace,omitempty"`
	Id          *string             `json:"id,omitempty"`
	Type        NodeType            `json:"type,omitempty"`
	AssetType   *string             `json:"assetType,omitempty"`
	DisplayName *string             `json:"displayName,omitempty"`
	Producer    *AssetWriteSummary  `json:"producer,omitempty"`
	Runs        []AssetWriteSummary `json:"runs,omitempty"`
	Collapsed   bool                `json:"collapsed"`
	TotalDegree *int64              `json:"totalDegree,omitempty"`
	NextCursor  *string             `json:"nextCursor,omitempty"`
	Exhausted   bool                `json:"exhausted"`
}

type AssetRelationGraphEdge struct {
	Source   string         `json:"source"`
	Target   string         `json:"target"`
	Kind     RelationKind   `json:"kind,omitempty"`
	Directed bool           `json:"directed"`
	Role     *string        `json:"role,omitempty"`
	Origin   RelationOrigin `json:"origin,omitempty"`
	TaskType *string        `json:"taskType,omitempty"`
}
