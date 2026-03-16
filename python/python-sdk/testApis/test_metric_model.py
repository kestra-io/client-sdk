# coding: utf-8

import unittest

from pydantic import ValidationError

from kestrapy.models.metric import Metric


class TestMetricModel(unittest.TestCase):
    def test_metric_accepts_numeric_value(self) -> None:
        metric = Metric.from_dict({
            "name": "worker.job.pending",
            "type": "WORKER",
            "value": 3
        })

        assert metric is not None
        assert metric.name == "worker.job.pending"
        assert metric.type == "WORKER"
        assert metric.value == 3

    def test_metric_rejects_object_value(self) -> None:
        with self.assertRaises(ValidationError):
            Metric.from_dict({
                "name": "worker.job.pending",
                "type": "WORKER",
                "value": {"pending": 3}
            })


if __name__ == '__main__':
    unittest.main()

