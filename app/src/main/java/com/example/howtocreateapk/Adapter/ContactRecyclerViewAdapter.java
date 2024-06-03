package com.example.howtocreateapk.Adapter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.howtocreateapk.MainActivity;
import com.example.howtocreateapk.Model.ContactModel;
import com.example.howtocreateapk.R;
import com.skydoves.elasticviews.ElasticButton;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

public class ContactRecyclerViewAdapter extends RecyclerView.Adapter<ContactRecyclerViewAdapter.ViewHolder> {
    private Context context;
    private final int Gallery_request_code = 100;
    private ArrayList<ContactModel> contactModelArrayList;

    public ContactRecyclerViewAdapter(Context context, ArrayList<ContactModel> contactModelArrayList) {
        this.context = context;
        this.contactModelArrayList = contactModelArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.contact_recycler, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ContactModel contactModel = contactModelArrayList.get(position);

        if (contactModel.getProfileImage() instanceof Integer) {
            holder.profileImage.setImageResource((Integer) contactModel.getProfileImage());
        } else if (contactModel.getProfileImage() instanceof Uri) {
            holder.profileImage.setImageURI((Uri) contactModel.getProfileImage());
        }

        holder.name.setText(contactModel.getName());
        holder.phone.setText(contactModel.getPhone());
        holder.message.setText(contactModel.getMessage());
        holder.time.setText(contactModel.getTime());

        holder.idRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.add_contact);
                TextView handingText = dialog.findViewById(R.id.AddContact);
                ElasticButton submit_button = dialog.findViewById(R.id.submit_button);
                EditText name_input = dialog.findViewById(R.id.name_input);
                ImageView profile_image = dialog.findViewById(R.id.profile_image);
                EditText contact_input = dialog.findViewById(R.id.contact_input);
                EditText time_input = dialog.findViewById(R.id.time_input);
                EditText message_input = dialog.findViewById(R.id.message_input);

                // Pre-fill the dialog with the contact's data
                name_input.setText(contactModel.getName());
                contact_input.setText(contactModel.getPhone());
                time_input.setText(contactModel.getTime());
                message_input.setText(contactModel.getMessage());
                submit_button.setText("Update");
                handingText.setText("Update Contact");

                if (contactModel.getProfileImage() instanceof Uri) {
                    profile_image.setImageURI((Uri) contactModel.getProfileImage());
                    profile_image.setTag(contactModel.getProfileImage());
                } else if (contactModel.getProfileImage() instanceof Integer) {
                    profile_image.setImageResource((Integer) contactModel.getProfileImage());
                    profile_image.setTag(contactModel.getProfileImage());
                }

                time_input.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showTimePickerDialog(time_input);
                    }
                });
                profile_image.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showImageGallery(profile_image);
                    }
                });

                submit_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name = name_input.getText().toString();
                        String phone = contact_input.getText().toString();
                        String time = time_input.getText().toString();
                        String message = message_input.getText().toString();
                        Object profile = profile_image.getTag(); // get the tag we set earlier

                        if (!name.isEmpty() && !phone.isEmpty() && !time.isEmpty() && !message.isEmpty() && profile != null) {
                            contactModelArrayList.set(position, new ContactModel(profile, name, phone, message, time));
                            notifyItemChanged(position);
                            dialog.dismiss();
                        }
                    }
                });

                dialog.show();
            }
        });

        holder.idRelativeLayout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(context)
                        .setTitle("Delete Contact")
                        .setMessage("Are you sure you want to delete the contact ")
                        .setIcon(R.drawable.delete_svgrepo_com)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                contactModelArrayList.remove(position);
                                notifyItemRemoved(position);
                                Log.i("Tage","Contact is Deleted at "+position);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Log.i("Tage","Contact isn't Deleted at "+position+ " Is it cancel ");
                            }
                        });
                builder.show();
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return contactModelArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView profileImage;
        TextView name, phone, message, time;
        RelativeLayout idRelativeLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            profileImage = itemView.findViewById(R.id.profile_image);
            name = itemView.findViewById(R.id.name);
            phone = itemView.findViewById(R.id.phone);
            message = itemView.findViewById(R.id.message);
            time = itemView.findViewById(R.id.time);
            idRelativeLayout = itemView.findViewById(R.id.idRelativeLayout);
        }
    }

    private void showTimePickerDialog(EditText time_input) {
        Calendar calendar = Calendar.getInstance();
        int hours = calendar.get(Calendar.HOUR_OF_DAY);
        int mins = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(context, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                Calendar calendar1 = Calendar.getInstance();
                calendar1.set(Calendar.HOUR_OF_DAY, hourOfDay);
                calendar1.set(Calendar.MINUTE, minute);
                calendar1.setTimeZone(TimeZone.getDefault());
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm a");

                String time = simpleDateFormat.format(calendar1.getTime());
                time_input.setText(time);
            }
        }, hours, mins, false);
        timePickerDialog.show();
    }

    private void showImageGallery(ImageView profile_image) {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        ((MainActivity) context).startActivityForResult(intent, Gallery_request_code);
    }

    // Call this method when the image is selected in the MainActivity
    public void setImageUri(Uri uri, ImageView profile_image) {
        profile_image.setImageURI(uri);
        profile_image.setTag(uri);
    }
}
