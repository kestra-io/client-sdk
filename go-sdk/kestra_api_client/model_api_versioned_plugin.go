package kestra_api_client

// ApiPluginIcon is the icon metadata attached to a plugin artifact.
type ApiPluginIcon struct {
	HasIcon    bool   `json:"hasIcon"`
	Monochrome bool   `json:"monochrome"`
	Hash       string `json:"hash,omitempty"`
}

func (o *ApiPluginIcon) GetHasIcon() bool { return o.HasIcon }

// ApiAvailablePlugin is an installable plugin returned by the versioned-plugins
// "available" endpoints.
type ApiAvailablePlugin struct {
	Title      string         `json:"title,omitempty"`
	GroupId    string         `json:"groupId,omitempty"`
	ArtifactId string         `json:"artifactId,omitempty"`
	Icon       *ApiPluginIcon `json:"icon,omitempty"`
}

func (o *ApiAvailablePlugin) GetTitle() string      { return o.Title }
func (o *ApiAvailablePlugin) GetArtifactId() string { return o.ArtifactId }

// ApiPluginArtifact is an installed plugin artifact and its available versions.
type ApiPluginArtifact struct {
	Title           string         `json:"title,omitempty"`
	GroupId         string         `json:"groupId,omitempty"`
	ArtifactId      string         `json:"artifactId,omitempty"`
	Icon            *ApiPluginIcon `json:"icon,omitempty"`
	Versions        []string       `json:"versions,omitempty"`
	ReleaseNotesUrl string         `json:"releaseNotesUrl,omitempty"`
}

func (o *ApiPluginArtifact) GetArtifactId() string { return o.ArtifactId }
func (o *ApiPluginArtifact) GetVersions() []string { return o.Versions }

// ApiAvailablePluginList is the {total, results} envelope of the
// versioned-plugins "available" endpoints.
type ApiAvailablePluginList struct {
	Total   int32                `json:"total"`
	Results []ApiAvailablePlugin `json:"results,omitempty"`
}

func (o *ApiAvailablePluginList) GetTotal() int32                  { return o.Total }
func (o *ApiAvailablePluginList) GetResults() []ApiAvailablePlugin { return o.Results }

// PagedResultsApiPluginArtifact is a page of installed plugin artifacts.
type PagedResultsApiPluginArtifact struct {
	Results []ApiPluginArtifact `json:"results"`
	Total   int64               `json:"total"`
}

func (o *PagedResultsApiPluginArtifact) GetResults() []ApiPluginArtifact { return o.Results }
func (o *PagedResultsApiPluginArtifact) GetTotal() int64                 { return o.Total }
