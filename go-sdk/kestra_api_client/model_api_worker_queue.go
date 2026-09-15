package kestra_api_client

// ApiWorkerQueueList wraps the worker queues returned by the list endpoint.
type ApiWorkerQueueList struct {
	WorkerQueues []ApiWorkerQueueItem `json:"workerQueues,omitempty"`
}

func (o *ApiWorkerQueueList) GetWorkerQueues() []ApiWorkerQueueItem { return o.WorkerQueues }

// ApiWorkerQueueItem is a worker queue as returned in the list, including the
// count of workers currently serving it.
type ApiWorkerQueueItem struct {
	Id             string   `json:"id"`
	Name           string   `json:"name,omitempty"`
	Description    string   `json:"description,omitempty"`
	Tags           []string `json:"tags,omitempty"`
	AllowedTenants []string `json:"allowedTenants,omitempty"`
	ActiveWorkers  int32    `json:"activeWorkers"`
}

func (o *ApiWorkerQueueItem) GetId() string             { return o.Id }
func (o *ApiWorkerQueueItem) GetName() string           { return o.Name }
func (o *ApiWorkerQueueItem) GetTags() []string         { return o.Tags }
func (o *ApiWorkerQueueItem) GetActiveWorkers() int32   { return o.ActiveWorkers }

// ApiWorkerQueueDetails is the full worker queue returned by the get endpoint,
// including the workers currently serving it.
type ApiWorkerQueueDetails struct {
	Id             string            `json:"id"`
	Name           string            `json:"name,omitempty"`
	Description    string            `json:"description,omitempty"`
	Tags           []string          `json:"tags,omitempty"`
	AllowedTenants []string          `json:"allowedTenants,omitempty"`
	Workers        []ServiceInstance `json:"workers,omitempty"`
}

func (o *ApiWorkerQueueDetails) GetId() string               { return o.Id }
func (o *ApiWorkerQueueDetails) GetName() string             { return o.Name }
func (o *ApiWorkerQueueDetails) GetTags() []string           { return o.Tags }
func (o *ApiWorkerQueueDetails) GetWorkers() []ServiceInstance { return o.Workers }

// ApiWorkerQueueSubscribers lists the worker groups subscribed to a worker queue.
type ApiWorkerQueueSubscribers struct {
	Groups []ApiSubscribingGroup `json:"groups,omitempty"`
}

func (o *ApiWorkerQueueSubscribers) GetGroups() []ApiSubscribingGroup { return o.Groups }

// ApiSubscribingGroup is a worker group subscribed to a worker queue.
type ApiSubscribingGroup struct {
	Id   string `json:"id"`
	Name string `json:"name,omitempty"`
}

func (o *ApiSubscribingGroup) GetId() string   { return o.Id }
func (o *ApiSubscribingGroup) GetName() string { return o.Name }
