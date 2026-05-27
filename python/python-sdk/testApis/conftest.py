import os
import sys

import pytest

from kestrapy import Configuration, KestraClient

# Make test_helpers importable from test files
sys.path.insert(0, os.path.dirname(__file__))


@pytest.fixture(scope="session")
def client():
    configuration = Configuration()
    configuration.host = "http://localhost:9902"
    configuration.username = "root@root.com"
    configuration.password = "Root!1234"
    return KestraClient(configuration)
