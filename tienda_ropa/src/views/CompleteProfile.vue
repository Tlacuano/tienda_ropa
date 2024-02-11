<template>
    <b-modal id="completeProfile" title="Completar perfil" hide-footer centered>
      <b-container fluid>
        <b-form>
          <b-form-group>
            <b-form-input
              v-model="profile.name"
              placeholder="Nombre"
              required
            ></b-form-input>
          </b-form-group>
          <b-form-group>
            <b-form-input
              v-model="profile.lastName1"
              placeholder="Primer apellido"
              required
            ></b-form-input>
          </b-form-group>
          <b-form-group>
            <b-form-input
              v-model="profile.lastName2"
              placeholder="Segundo apellido"
              required
            ></b-form-input>
          </b-form-group>
          <b-form-group>
            <b-form-input
              v-model="profile.birthDate"
              type="date"
              required
            ></b-form-input>
            <div class="birthDate-requirements">
              La fecha de nacimiento debe indicar que eres mayor de 18 años.
            </div>
          </b-form-group>
          <b-form-group label="Foto de perfil" class="text-center">
            <div class="avatar-preview">
              <img
                v-if="profile.avatar"
                :src="profile.avatar"
                class="avatar-preview-image"
                alt="Avatar Preview"
              />
              <b-icon v-else icon="person-circle" class="avatar-icon"></b-icon>
            </div>
            <input
              type="file"
              @change="handleFileUpload"
              class="form-control-file"
            />
          </b-form-group>
          <b-row class="mt-3 text-center">
            <b-col>
              <b-button class="custom-button-light" block @click="cancel"
                >Omitir</b-button
              >
            </b-col>
            <b-col>
              <b-button class="custom-button" block @click="complete"
                >Finalizar</b-button
              >
            </b-col>
          </b-row>
        </b-form>
      </b-container>
    </b-modal>
  </template>
  
  <script lang="ts">
  import Vue from "vue";
  export default Vue.extend({
    name: "CompleteProfile",
    data() {
      return {
        profile: {
          name: "",
          lastName1: "",
          lastName2: "",
          birthDate: null,
          avatar: null,
        },
      };
    },
    methods: {
      cancel() {
        this.$emit("cancelCompleteProfile");
      },
      complete() {
        this.$emit("completeProfile", this.profile);
      },
      handleFileUpload(e: any) {
        const file = e.target.files[0];
        if (file) {
          const reader = new FileReader();
          reader.onload = (e) => {
            if (e.target && e.target.result) {
              console.log(e.target.result);
            }
          };
          reader.readAsDataURL(file);
        }
      },
    },
  });
  </script>
  
  <style>
  .avatar-preview {
    width: 4cm;
    height: 4cm;
    border-radius: 50%;
    overflow: hidden;
    margin-bottom: 15px;
    background-color: #f0f0f0;
    display: flex;
    align-items: center;
    justify-content: center;
  }
  
  .avatar-icon {
    font-size: 3rem;
  }
  
  .avatar-preview-image {
    width: 100%;
    height: 100%;
    object-fit: cover;
    border-radius: 50%;
  }
  
  .birthDate-requirements {
    font-size: 0.8em;
    color: #888;
    margin-top: 2px;
  }
  
  .form-control-file {
    display: inline-block;
    width: auto;
    margin-top: 10px;
  }
  
  .custom-button-light {
    background-color: #919294;
  }
  </style>
  