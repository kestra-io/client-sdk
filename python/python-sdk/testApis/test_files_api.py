import tempfile
import os

import pytest

from kestrapy.exceptions import ApiException
from test_helpers import TENANT, random_id, random_namespace, log_flow_yaml, create_flow


# ========================================================================
# Helpers
# ========================================================================

def make_temp_file(name, content):
    """Create a temporary file with the given content and return its path."""
    fd, path = tempfile.mkstemp(prefix=name, suffix=".txt")
    with os.fdopen(fd, "w") as f:
        f.write(content)
    return path


# ========================================================================
# Directories
# ========================================================================

def test_create_namespace_directory_basic(client):
    ns = random_namespace()
    create_flow(client, log_flow_yaml(random_id(), ns))

    # Should not raise
    client.files.create_namespace_directory(ns, TENANT, "/testdir")


def test_list_namespace_directory_files_basic(client):
    ns = random_namespace()
    create_flow(client, log_flow_yaml(random_id(), ns))

    tmp = make_temp_file("hello", "world")
    try:
        with open(tmp, "rb") as f:
            client.files.create_namespace_file(ns, "/hello.txt", TENANT, f.read())
    finally:
        os.unlink(tmp)

    files = client.files.list_namespace_directory_files(ns, TENANT)
    assert files is not None
    assert len(files) > 0


def test_list_namespace_directory_files_empty(client):
    ns = random_namespace()
    create_flow(client, log_flow_yaml(random_id(), ns))

    files = client.files.list_namespace_directory_files(ns, TENANT)
    assert files is not None


# ========================================================================
# Files
# ========================================================================

def test_create_and_get_namespace_file(client):
    ns = random_namespace()
    create_flow(client, log_flow_yaml(random_id(), ns))

    tmp = make_temp_file("myfile", "content here")
    try:
        with open(tmp, "rb") as f:
            client.files.create_namespace_file(ns, "/myfile.txt", TENANT, f.read())
    finally:
        os.unlink(tmp)

    downloaded = client.files.file_content(ns, "/myfile.txt", TENANT)
    assert downloaded is not None
    assert len(downloaded) > 0


def test_file_metadatas_basic(client):
    ns = random_namespace()
    create_flow(client, log_flow_yaml(random_id(), ns))

    tmp = make_temp_file("meta", "some data")
    try:
        with open(tmp, "rb") as f:
            client.files.create_namespace_file(ns, "/meta.txt", TENANT, f.read())
    finally:
        os.unlink(tmp)

    attrs = client.files.file_metadatas(ns, TENANT, "/meta.txt")
    assert attrs is not None


def test_file_revisions_basic(client):
    ns = random_namespace()
    create_flow(client, log_flow_yaml(random_id(), ns))

    tmp = make_temp_file("rev", "version 1")
    try:
        with open(tmp, "rb") as f:
            client.files.create_namespace_file(ns, "/rev.txt", TENANT, f.read())
    finally:
        os.unlink(tmp)

    revisions = client.files.file_revisions(ns, TENANT, "/rev.txt")
    assert revisions is not None


# ========================================================================
# Move & Delete
# ========================================================================

def test_move_file_directory_basic(client):
    ns = random_namespace()
    create_flow(client, log_flow_yaml(random_id(), ns))

    tmp = make_temp_file("move", "data")
    try:
        with open(tmp, "rb") as f:
            client.files.create_namespace_file(ns, "/tomove.txt", TENANT, f.read())
    finally:
        os.unlink(tmp)

    # Should not raise
    client.files.move_file_directory(ns, "/tomove.txt", "/moved.txt", TENANT)


def test_delete_file_directory_basic(client):
    ns = random_namespace()
    create_flow(client, log_flow_yaml(random_id(), ns))

    tmp = make_temp_file("del", "data")
    try:
        with open(tmp, "rb") as f:
            client.files.create_namespace_file(ns, "/todelete.txt", TENANT, f.read())
    finally:
        os.unlink(tmp)

    # Should not raise
    client.files.delete_file_directory(ns, "/todelete.txt", TENANT)


# ========================================================================
# Search & Export
# ========================================================================

def test_search_namespace_files_basic(client):
    ns = random_namespace()
    create_flow(client, log_flow_yaml(random_id(), ns))

    tmp = make_temp_file("search", "data")
    try:
        with open(tmp, "rb") as f:
            client.files.create_namespace_file(ns, "/searchable.txt", TENANT, f.read())
    finally:
        os.unlink(tmp)

    results = client.files.search_namespace_files(ns, "searchable", TENANT)
    assert results is not None
    assert len(results) > 0


def test_export_namespace_files_basic(client):
    ns = random_namespace()
    create_flow(client, log_flow_yaml(random_id(), ns))

    tmp = make_temp_file("export", "data")
    try:
        with open(tmp, "rb") as f:
            client.files.create_namespace_file(ns, "/export.txt", TENANT, f.read())
    finally:
        os.unlink(tmp)

    zip_bytes = client.files.export_namespace_files(ns, TENANT)
    assert zip_bytes is not None
    assert len(zip_bytes) > 0
