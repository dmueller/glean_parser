/*
 * AUTOGENERATED BY glean_parser.  DO NOT EDIT.
 */

/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package GleanMetrics

{% for metric_type in metric_types -%}
import mozilla.components.service.glean.{{ metric_type|Camelize }}MetricType
{% endfor %}

object {{ category_name|Camelize }} {
    {% for metric in metrics.values() %}
    /**
     * {{ metric.description|wordwrap(wrapstring='\n     * ') }}
     */
    val {{ metric.name|camelize }}: {{ metric.type|Camelize }}MetricType by lazy {
        {{ metric.type|Camelize }}MetricType(
            {% for arg_name in extra_args if metric[arg_name] is defined -%}
            {{ arg_name|camelize }}={{ metric[arg_name]|kotlin }}{{ "," if not loop.last }}
            {% endfor -%}
        )
    };
    {% endfor %}
}
