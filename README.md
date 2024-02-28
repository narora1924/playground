# pgmgmt-core-db documentation

## schemas

| name | description |
| ---- | ----------- |
| audit | change tracking |
| auth | users and roles |
| core | common tables |
| earn | earnings module |
| pay | pay module |


# Entity Relationship Diagrams

## audit

```mermaid
---
title: Audit Schema
---
erDiagram
  history
  "core.users" |o--|{ history : "schema.table"
  "pay.batches" |o--|{ history : "schema.table"
  "pay.payables" |o--|{ history : "schema.table"
  "pay.payments" |o--|{ history : "schema.table"
  "pay.sources" |o--|{ history : "schema.table"
```

## auth

```mermaid
---
title: Auth Schema
---
erDiagram
  feature_flag ||--o{ feature_lkp : feature_flag_key
  feature_lkp ||--o{ scope_xref : feature_key
  verb_lkp ||--o{ scope_xref : verb_key
  scope_xref ||--o{ scope_role_xref : scope_xref_key
  role_category_lkp ||--o{ role_lkp : role_category_key
  role_lkp ||--o{ impersonation_role_access : role_key
  role_lkp ||--o{ scope_role_xref : role_key
  scope_area ||--o{ scope_xref : scope_area_key
  impersonation_individual_access
  impersonation_log
  repo_queries_for_scope_load
```

## core

```mermaid
---
title: Core Schema
---
erDiagram
  approvals
  client_settings
  customers
  customers |o--|{ customer_histories : customer_id
  customers ||--o{ customer_addresses : customer_id
  customer_addresses |o--|{ customer_address_histories : customer_address_id
  customers ||--o{ customer_contexts : customer_id
  customer_hierarchy_types ||--o{ customer_contexts : customer_hierarchy_type_id
  customer_contexts ||--o{ customer_contexts : "id->parent_id"
  customer_contexts |o--|{ customer_context_histories : customer_context_id
  customers ||--o{ customer_search_terms : customer_id
  customer_use_cases
  reports
  users
  zones

```

## earn

```mermaid
---
title: Earn Schema
---
erDiagram

```

## pay

```mermaid
---
title: Pay Schema
---
erDiagram
  temp_dem
  
  batches ||--o{ sources : batch_id
  sources ||--o{ payables : source_id
  batches ||--o{ payments : batch_id
  payments ||--|{ payables : payment_id
  batches |o--o{ comments : "batch_id->model_id"
  sources |o--o{ comments : "source_id->model_id"
  payables |o--o{ comments : "payable_id->model_id"
  payments |o--o{ comments : "payment_id->model_id"

```
