# coding: utf-8

"""
    Kestra Python SDK (kestrapy)

    All API operations, except for Instance-owner-only endpoints, require a tenant identifier in the HTTP path.<br/> Endpoints designated as Instance-owner-only are not tenant-scoped.

    Hand-written SDK for the Kestra API. Package metadata is authoritative in
    pyproject.toml; this file is kept for legacy tooling.
"""  # noqa: E501


from setuptools import setup, find_packages  # noqa: H301

# To install the library, run the following
#
# python setup.py install
#
# prerequisite: setuptools
# http://pypi.python.org/pypi/setuptools
NAME = "kestrapy"
VERSION = "2.0.0-rc1"
PYTHON_REQUIRES = ">= 3.9"
REQUIRES = [
"requests (>= 2.32.5)",
"sseclient-py (>= 1.8.0)",
"urllib3 >= 2.1.0, < 3.0.0",
"python-dateutil >= 2.8.2",
"pydantic >= 2",
"typing-extensions >= 4.7.1",
]

setup(
name=NAME,
version=VERSION,
description="Kestra Python SDK",
author="Kestra",
author_email="hello@kestra.io",
url="https://github.com/kestra-io/client-sdk",
keywords=["kestra", "sdk", "orchestration", "workflow"],
install_requires=REQUIRES,
packages=find_packages(exclude=["test", "tests"]),
include_package_data=True,
long_description_content_type='text/markdown',
long_description="""\
All API operations, except for Instance-owner-only endpoints, require a tenant identifier in the HTTP path.&lt;br/&gt; Endpoints designated as Instance-owner-only are not tenant-scoped.
""",  # noqa: E501
package_data={"kestrapy": ["py.typed"]},
)